package cn.appManager.service.backend_user;

import cn.appManager.dao.backend_user.BackendUserMapper;
import cn.appManager.pojo.BackendUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    private BackendUserMapper backendUserMapper;

    @Override
    public BackendUser getUserByUserCode(String userCode) {
        return backendUserMapper.getUserByUserCode(userCode);
    }
}
