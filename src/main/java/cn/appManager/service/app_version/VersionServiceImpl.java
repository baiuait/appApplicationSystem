package cn.appManager.service.app_version;

import cn.appManager.dao.app_info.AppInfoMapper;
import cn.appManager.dao.app_version.VersionMapper;
import cn.appManager.pojo.AppVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {
    @Resource
    private VersionMapper versionMapper;
    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppVersion> getVersionListByAppId(Integer appId) {
        return versionMapper.getVersionListByAppId(appId);
    }

    @Override
    public Integer getVersionCountByAppId(Integer appId) {
        return versionMapper.getVersionCountByAppId(appId);
    }

    @Override
    public Boolean saveVersion(AppVersion appVersion) {
        //获取添加成功后的主键
        versionMapper.saveVersion(appVersion);
        Integer versionId = appVersion.getId();
        //执行appInfo版本修改操作
        Integer result = appInfoMapper.modifyAppVersionById(versionId, appVersion.getAppId());
        return result > 0;
    }

    @Override
    public AppVersion getNewVersionByAppId(Integer appId) {
        return versionMapper.getNewVersionByAppId(appId);
    }

    @Override
    public Boolean modifyVersion(AppVersion appVersion) {
        return versionMapper.modifyVersion(appVersion) > 0;
    }
}
