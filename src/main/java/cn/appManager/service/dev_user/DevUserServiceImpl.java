package cn.appManager.service.dev_user;

import cn.appManager.dao.dev_user.DevUserMapper;
import cn.appManager.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserMapper devUserMapper;

    @Override
    public DevUser getDevUserByDevCode(String devCode) {
        //根据编号获取devUser对象
        DevUser devUser = devUserMapper.getDevUserByDevCode(devCode);
        return devUser;
    }
}
