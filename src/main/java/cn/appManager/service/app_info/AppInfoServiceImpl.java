package cn.appManager.service.app_info;

import cn.appManager.dao.app_info.AppInfoMapper;
import cn.appManager.dao.app_version.VersionMapper;
import cn.appManager.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;
    @Resource
    private VersionMapper versionMapper;

    @Override
    public List<AppInfo> getAppInfoList(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3, Integer currentPageNo, Integer pageSize) {
        Integer count = (currentPageNo - 1) * pageSize;
        return appInfoMapper.getAppInfoList(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3, count, pageSize);
    }

    @Override
    public Integer getAppInfoCount(String softwareName, Integer status, Integer flatformId, Integer categoryLevel1, Integer categoryLevel2, Integer categoryLevel3) {
        return appInfoMapper.getAppInfoCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
    }

    @Override
    public Boolean saveAppInfo(AppInfo appInfo) {
        return appInfoMapper.saveAppInfo(appInfo) > 0;
    }

    @Override
    public AppInfo getAppInfoById(Integer id) {
        return appInfoMapper.getAppInfoById(id);
    }

    @Override
    public Boolean modifyAppInfoById(AppInfo appInfo) {
        return appInfoMapper.modifyAppInfoById(appInfo) > 0;
    }

    @Override
    public Boolean deleteAppInfoById(Integer id) {
        //先删除版本信息
        versionMapper.deleteVersionsByAppId(id);
        //再删除appInfo
        Integer result = appInfoMapper.deleteAppInfoById(id);
        return result > 0;
    }

    @Override
    public Boolean modifyAppStatusById(Integer id, Integer status) {
        return appInfoMapper.modifyAppStatusById(id, status) > 0;
    }
}
