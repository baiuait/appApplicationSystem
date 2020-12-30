package cn.appManager.controller;

import cn.appManager.pojo.AppInfo;
import cn.appManager.pojo.AppVersion;
import cn.appManager.pojo.DevUser;
import cn.appManager.service.app_info.AppInfoService;
import cn.appManager.service.app_version.VersionService;
import cn.appManager.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/appInfo")
public class AppInfoController {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Resource
    private AppInfoService appInfoService;
    @Resource
    private VersionService versionService;

    /**
     * APP信息列表页面(根据条件进行筛选)
     */
    @RequestMapping("/appInfoList")
    public String getAppInfoList(Model model, @RequestParam(name = "softwareName", required = false)String softwareName,
                                 @RequestParam(name = "status", required = false)Integer status,
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
        Integer appInfoDataCount = appInfoService.getAppInfoCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
        //总页数
        Integer pagesCount = appInfoDataCount % pageSizeValue == 0 ? appInfoDataCount / pageSizeValue : appInfoDataCount / pageSizeValue + 1;
        List<AppInfo> appInfoList = appInfoService.getAppInfoList(softwareName, status, flatformId, categoryLevel1,
                categoryLevel2, categoryLevel3, currentPageNoValue, pageSizeValue);
        model.addAttribute(Constants.APP_INFO_REQUEST, appInfoList);
        model.addAttribute("softwareNameValue", softwareName);
        model.addAttribute("statusValue", status);
        model.addAttribute("flatformIdValue", flatformId);
        model.addAttribute("categoryLevel1Value", categoryLevel1);
        model.addAttribute("categoryLevel2Value", categoryLevel2);
        model.addAttribute("categoryLevel3Value", categoryLevel3);
        model.addAttribute("currentPageNoValue", currentPageNoValue);
        model.addAttribute("appInfoDataCount", appInfoDataCount);
        model.addAttribute("pagesCount", pagesCount);
        return "dev_user/appMaintain";
    }

    /**
     * 前往新增APP信息页面
     */
    @RequestMapping("/toAdd")
    public String goToAddInfoPage(){
        LOGGER.info("go to add app info page = = = = =");
        return "dev_user/appInfoAdd";
    }

    /**
     * 执行新增操作(包含上传图片
     */
    @RequestMapping("/doAdd")
    public String doAddOption(AppInfo appInfo, @RequestParam(value = "up_logoPicPath",required = false) MultipartFile pic,
                              HttpSession session, HttpServletRequest request){
        LOGGER.info("do add app info option = = = = =");
        //若上传图片不为空,执行上传图片操作
        String picPath = "";
        String locPath = "";
        if (!pic.isEmpty()){
            //获取target路径
            String path = session.getServletContext().getRealPath("statics"+ File.separator+ "images"+ File.separator+ "appLogo");
            //获取本地物理目录>>>>>
            String xmPath = "Z:"+ File.separator+ "projects"+ File.separator+ "AppManager"+ File.separator+
                    "src"+ File.separator+ "main"+ File.separator+ "webapp"+ File.separator+"statics"+ File.separator+ "images"+ File.separator+ "appLogo";
            //获取原文件名(判断后缀
            String oldFileName = pic.getOriginalFilename();
            //判断文件后缀
            if(oldFileName.endsWith(".jpg") || oldFileName.endsWith(".png")){
                //判断文件大小
                if(pic.getSize() > 500000){
                    request.setAttribute("fileError", "文件不能大于500KB");
                }
                else{
                    //生成文件名
                    String fileName = new Random().nextInt(1000000)+"_App.jpg";
                    File file = new File(path, fileName);
                    File xmParent = new File(xmPath);
                    File xmFile = new File(xmPath+File.separator+fileName);
                    //判断文件是否存在
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    if(!xmParent.exists())
                        xmParent.mkdirs();
                    try {
                        //转移文件
                        pic.transferTo(file);
                        //无法转移文件两次,因此使用复制
                        Files.copy(file.toPath(),xmFile.toPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                        request.setAttribute("fileError", "文件上传失败!");
                    }
                    picPath = path + File.separator + fileName;
                    locPath = xmPath + File.separator + fileName;
                }
            }else{
                request.setAttribute("fileError", "文件格式只能为.jpg,.png");
            }
        }

        //需要devId, creationDate, createdBy, versionId
        appInfo.setDevId(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
        appInfo.setCreationDate(new Date());
        appInfo.setLogoPicPath(picPath);
        appInfo.setLogoLocPath(locPath);
        appInfo.setCreatedBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
        Boolean result = appInfoService.saveAppInfo(appInfo);
        if(result)
            return "redirect:/appInfo/appInfoList";
        return "dev_user/appInfoAdd";
    }

    /**
     * 前往APP信息修改页面
     */
    @RequestMapping("/toModify/{id}")
    public String goToModify(@PathVariable Integer id, Model model){
        LOGGER.info("go to modify page id = = = = = "+id);
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo", appInfo);
        return "dev_user/appModify";
    }

    /**
     * 执行修改操作
     */
    @RequestMapping("/doModify")
    public String doModifyAppInfo(AppInfo appInfo, HttpSession session){
        LOGGER.info("do modify app info id = = = = = "+appInfo.getId());
        //添加修改人和修改时间
        appInfo.setModifyBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
        appInfo.setModifyDate(new Date());
        //执行修改操作
        Boolean result = appInfoService.modifyAppInfoById(appInfo);
        if (!result)
            return "dev_user/appModify";
        return "redirect:/appInfo/appInfoList";
    }

    //查看App信息
    @RequestMapping("/view/{appId}")
    public String goToViewPage(@PathVariable Integer appId, Model model){
        LOGGER.info("go to view page appId = = = = = "+appId);
        //获取app信息
        AppInfo appInfo = appInfoService.getAppInfoById(appId);
        //获取版本列表
        List<AppVersion> versionList = versionService.getVersionListByAppId(appId);
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("versionList", versionList);
        return "dev_user/appInfoView";
    }

    //删除AppInfo(异步)
    @RequestMapping("/delete/{appId}")
    @ResponseBody
    public String deleteAppInfo(@PathVariable Integer appId){
        LOGGER.info("delete app info appId = = = = = "+appId);
        Boolean result = appInfoService.deleteAppInfoById(appId);
        return "{\"result\":\""+result+"\"}";
    }

    //修改App状态(异步)
    @RequestMapping("/modifyStatus")
    @ResponseBody
    public String modifyStatus(Integer id, Integer status){
        LOGGER.info("modify status id = = = = = "+id);
        Boolean result = appInfoService.modifyAppStatusById(id, status);
        return "{\"result\":\""+result+"\"}";
    }
}
