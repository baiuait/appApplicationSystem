package cn.appManager.interceptor;

import cn.appManager.pojo.DevUser;
import cn.appManager.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断登陆拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DevUser devUser = (DevUser)request.getSession().getAttribute(Constants.USER_SESSION);
        if (null == devUser){
            LOGGER.error("intercept access requests=====");
            response.sendRedirect(request.getContextPath()+"/403.jsp");
            return false;
        }
        return true;
    }
}
