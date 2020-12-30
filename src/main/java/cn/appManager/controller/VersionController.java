package cn.appManager.controller;

import cn.appManager.pojo.AppVersion;
import cn.appManager.pojo.DevUser;
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
@RequestMapping("/version")
public class VersionController {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Resource
    private VersionService versionService;

    /**
     * 前往app对应的VersionList
     */
    @RequestMapping("/versionList/{appId}")
    public String goToVersionListPage(@PathVariable Integer appId, Model model){
        LOGGER.info("go to version list page app id = = = = = "+appId);
        List<AppVersion> versionList = versionService.getVersionListByAppId(appId);
        model.addAttribute("versionList", versionList);
        model.addAttribute("appId", appId);
        return "dev_user/appVersionList";
    }

    /**
     * 查询App下的版本个数
     */
    @RequestMapping("/versionCount/{appId}")
    @ResponseBody
    public String getVersionCountByAppId(@PathVariable Integer appId){
        LOGGER.info("get version count app id = = = = = "+appId);
        Integer count = versionService.getVersionCountByAppId(appId);
        return "{\"count\":\""+count+"\"}";
    }

    /**
     * 添加version
     */
    @RequestMapping("/versionAdd")
    public String doAddVersion(AppVersion appVersion, @RequestParam(value = "up_apkLocPath", required = false) MultipartFile apkFile ,
                               HttpSession session, HttpServletRequest request){
        LOGGER.info("do add version option = = = = =");
        //文件上传操作
        String apkPath = "";
        String apkName = "";
        if (!apkFile.isEmpty()){
            //获取target路径
            String path = session.getServletContext().getRealPath("statics"+ File.separator+ "apk");
            //获取原文件名(判断后缀
            String oldFileName = apkFile.getOriginalFilename();
            //判断文件后缀
            if(oldFileName.endsWith(".apk")){
                //判断文件大小
                if(apkFile.getSize() > 50000000){
                    request.setAttribute("fileError", "文件不能大于500MB");
                }
                else{
                    //使用原文件名
                    File file = new File(path, oldFileName);
                    //判断文件是否存在
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    try {
                        //转移文件
                        apkFile.transferTo(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                        request.setAttribute("fileError", "文件上传失败!");
                    }
                    apkPath = path + File.separator + oldFileName;
                    apkName = oldFileName;
                }
            }else{
                request.setAttribute("fileError", "文件格式只能为.apk");
            }
        }
        //赋值apk路径和apk名
        appVersion.setApkLocPath(apkPath);
        appVersion.setApkFileName(apkName);
        //赋值创建时间和创始人
        appVersion.setCreatedBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
        appVersion.setCreationDate(new Date());
        Boolean result = versionService.saveVersion(appVersion);
        if(result)
            //重定向versionList方法中重新查询
            return "redirect:/version/versionList/"+appVersion.getAppId();
        return "dev_user/appVersionList";
    }

    //前往versionModify页面
    @RequestMapping("/versionModifyPage/{appId}")
    public String goToVersionModifyPage(@PathVariable Integer appId, Model model){
        LOGGER.info("go to version modify page app id = = = = = "+appId);
        //获取版本列表
        List<AppVersion> versionList = versionService.getVersionListByAppId(appId);
        model.addAttribute("versionList", versionList);
        //获取最新版本
        AppVersion newVersion = versionService.getNewVersionByAppId(appId);
        model.addAttribute("newVersion", newVersion);
        model.addAttribute("appId", appId);
        return "dev_user/appVersionModify";
    }

    //执行versionModify操作
    @RequestMapping("/versionModify")
    public String versionModify(AppVersion appVersion, HttpSession session){
        LOGGER.info("do version modify option version id = = = = = "+appVersion.getId());
        //赋值创建时间和创始人
        appVersion.setModifyBy(((DevUser)session.getAttribute(Constants.USER_SESSION)).getId());
        appVersion.setModifyDate(new Date());
        //执行修改操作
        Boolean result = versionService.modifyVersion(appVersion);
        if(result)
            session.setAttribute("modifyResult", "修改成功");
        else
            session.setAttribute("modifyResult", "修改失败");
        return "redirect:/version/versionModifyPage/"+appVersion.getAppId();
    }
}
