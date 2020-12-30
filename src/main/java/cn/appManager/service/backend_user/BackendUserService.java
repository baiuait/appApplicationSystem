package cn.appManager.service.backend_user;

import cn.appManager.pojo.BackendUser;

public interface BackendUserService {
    /**
     * 根据用户编号获取用户对象
     * @param userCode
     * @return
     */
    BackendUser getUserByUserCode(String userCode);
}
