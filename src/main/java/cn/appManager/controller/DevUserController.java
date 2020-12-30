package cn.appManager.controller;

import cn.appManager.pojo.DevUser;
import cn.appManager.service.dev_user.DevUserService;
import cn.appManager.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 开发者用户控制层
 */
@Controller
@RequestMapping("/devUser")
public class DevUserController {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Resource
    private DevUserService devUserService;

    /**
     * 前往登陆页面
     * @return
     */
    @RequestMapping("/goLogin")
    public String goLoginPage(){
        LOGGER.info("go login page = = = = =");
        return "dev_user/login";
    }

    /**
     * 验证登陆是否成功
     * @param devCode
     * @param devPassword
     * @return
     */
    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam("devCode") String devCode,
                          @RequestParam("devPassword") String devPassword,
                          HttpServletRequest request){
        LOGGER.info("do login = = = = =");
        DevUser devUser = devUserService.getDevUserByDevCode(devCode);
        //判断用户名是否存在
        if(null == devUser){
            request.setAttribute("loginMsg", "用户名不存在");
            return "dev_user/login";
        }
        //判断密码是否正确
        if(!devPassword.equals(devUser.getDevPassword())){
            request.setAttribute("loginMsg", "密码不正确");
            return "dev_user/login";
        }
        //判断通过>>>>
        request.getSession().setAttribute(Constants.USER_SESSION, devUser);
        return "redirect:/devUser/checkLogin/main";
    }

    /**
     * 执行登出操作
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "redirect:/devUser/goLogin";
    }
    /**
     * 登陆成功后前往主页面
     * @return
     */
    @RequestMapping("/checkLogin/main")
    public String goMainPage(){
        LOGGER.info("go main page = = = = =");
        return "dev_index";
    }

    /**
     * 异步加载index页面的各项内容
     */
//    @RequestMapping("/content/{path}")
//    public ModelAndView loadingContent(@PathVariable String path){
//        LOGGER.info("content "+path+" loading = = = = =");
//        ModelAndView mav = new ModelAndView("dev_user/content/"+path);
//        return mav;
//    }

    /**
     * 前往APP维护页面
     */
    @RequestMapping("/toAppMaintain")
    public String goToAppMaintainPage(){
        LOGGER.info("go to app maintain page = = = = =");
        return "redirect:/appInfo/appInfoList";
    }
}
