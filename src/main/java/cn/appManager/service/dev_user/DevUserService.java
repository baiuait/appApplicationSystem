package cn.appManager.service.dev_user;

import cn.appManager.pojo.DevUser;

public interface DevUserService {
    /**
     * 根据用户编码获取用户对象以判断用户登录
     * @param devCode
     * @return
     */
    DevUser getDevUserByDevCode(String devCode);
}
