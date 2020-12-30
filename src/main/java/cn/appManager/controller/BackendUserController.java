package cn.appManager.controller;

import cn.appManager.pojo.AppInfo;
import cn.appManager.pojo.AppVersion;
import cn.appManager.pojo.BackendUser;
import cn.appManager.pojo.DevUser;
import cn.appManager.service.app_info.AppInfoService;
import cn.appManager.service.app_version.VersionService;
import cn.appManager.service.backend_user.BackendUserService;
import cn.appManager.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/backendUser")
public class BackendUserController {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Resource
    private BackendUserService backendUserService;
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private VersionService versionService;

    /**
     * 前往登陆页面
     * @return
     */
    @RequestMapping("/goLogin")
    public String goLoginPage(){
        LOGGER.info("go login page = = = = =");
        return "backend_user/login";
    }

    /**
     * 验证登陆是否成功
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("userCode") String userCode,
                          @RequestParam("userPassword") String userPassword,
                          HttpServletRequest request){
        LOGGER.info("do login = = = = =");
        BackendUser backendUser = backendUserService.getUserByUserCode(userCode);
        //判断用户名是否存在
        if(null == backendUser){
            request.setAttribute("loginMsg", "用户名不存在");
            return "backend_user/login";
        }
        //判断密码是否正确
        if(!userPassword.equals(backendUser.getUserPassword())){
            request.setAttribute("loginMsg", "密码不正确");
            return "backend_user/login";
        }
        //判断通过>>>>
        request.getSession().setAttribute(Constants.BACKEND_USER_SESSION, backendUser);
        return "redirect:/backendUser/main";
    }

    /**
     * 前往主页面
     */
    @RequestMapping("/main")
    public String main(){
        LOGGER.info("go main = = = = =");
        return "backend_index";
    }

    /**
     * 登出操作
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        LOGGER.info("do logout = = = = =");
        session.removeAttribute(Constants.BACKEND_USER_SESSION);
        return "redirect:/backendUser/goLogin";
    }

    /**
     * 前往App信息列表页面
     */
    @RequestMapping("/toAppMaintain")
    public String goToAppMaintainPage(){
        LOGGER.info("go to app maintain page = = = = =");
        return "redirect:/backendUser/appInfoList";
    }

    /**
     * APP信息列表页面(根据条件进行筛选)
     */
    @RequestMapping("/appInfoList")
    public String getAppInfoList(Model model, @RequestParam(name = "softwareName", required = false)String softwareName,
                                 @RequestParam(name = "flatformId", required = false)Integer flatformId,
                                 @RequestParam(name = "categoryLevel1", required = false)Integer categoryLevel1,
                                 @RequestParam(name = "categoryLevel2", required = false)Integer categoryLevel2,
                                 @RequestParam(name = "categoryLevel3", required = false)Integer categoryLevel3,
                                 @RequestParam(name = "currentPageNo", required = false)Integer currentPageNo){
        //当前页数
        Integer currentPageNoValue = currentPageNo == null ? 1 : currentPageNo;
        //页大小
        Integer pageSizeValue = 5;
        //数据总数
        Integer appInfoDataCount = appInfoService.getAppInfoCount(softwareName, 1, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
        //总页数
        Integer pagesCount = appInfoDataCount % pageSizeValue == 0 ? appInfoDataCount / pageSizeValue : appInfoDataCount / pageSizeValue + 1;
        List<AppInfo> appInfoList = appInfoService.getAppInfoList(softwareName, 1, flatformId, categoryLevel1,
                categoryLevel2, categoryLevel3, currentPageNoValue, pageSizeValue);
        model.addAttribute(Constants.APP_INFO_REQUEST, appInfoList);
        model.addAttribute("softwareNameValue", softwareName);
        model.addAttribute("flatformIdValue", flatformId);
        model.addAttribute("categoryLevel1Value", categoryLevel1);
        model.addAttribute("categoryLevel2Value", categoryLevel2);
        model.addAttribute("categoryLevel3Value", categoryLevel3);
        model.addAttribute("currentPageNoValue", currentPageNoValue);
        model.addAttribute("appInfoDataCount", appInfoDataCount);
        model.addAttribute("pagesCount", pagesCount);
        return "backend_user/appMaintain";
    }

    /**
     * 前往App审核页面
     */
    @RequestMapping("/appExamine/{appId}")
    public String appExamine(@PathVariable Integer appId, Model model){
        LOGGER.info("go to app examine page appId = = = = = "+appId);
        //获取app信息
        AppInfo appInfo = appInfoService.getAppInfoById(appId);
        //获取最新版本信息
        AppVersion version = versionService.getNewVersionByAppId(appId);
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("newVersion", version);
        return "backend_user/appExamine";
    }

    /**
     * 审核通过/不通过
     */
    @RequestMapping("/examine/{appId}/{status}")
    public String examineApp(@PathVariable Integer appId, @PathVariable Integer status){
        LOGGER.info("to change app examine appId = = = = = "+appId);
        Boolean result = appInfoService.modifyAppStatusById(appId, status);
        if (result)
            return "redirect:/backendUser/appInfoList";
        return "backend_user/appExamine";
    }

    /**
     * 下载apk文件
     */
    @RequestMapping("/downloadApk/{appId}")
    public void down(HttpSession session, HttpServletResponse response, @PathVariable Integer appId) throws Exception{
        AppVersion newVersion = versionService.getNewVersionByAppId(appId);
        String fileName = session.getServletContext().getRealPath("statics"+ File.separator+ "apk")+File.separator+newVersion.getApkFileName();
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        String filename = newVersion.getApkFileName();
        filename = URLEncoder.encode(filename,"UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
