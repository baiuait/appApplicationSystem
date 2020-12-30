package cn.appManager.dao.backend_user;

import cn.appManager.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendUserMapper {
    /**
     * 根据用户编号获取用户对象
     * @param userCode
     * @return
     */
    BackendUser getUserByUserCode(@Param("userCode")String userCode);
}
