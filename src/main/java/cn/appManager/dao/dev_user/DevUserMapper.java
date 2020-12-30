package cn.appManager.dao.dev_user;

import cn.appManager.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevUserMapper {
    /**
     * 根据用户编号获取用户对象
     * @param devCode
     * @return
     */
    DevUser getDevUserByDevCode(@Param("devCode") String devCode);
}
