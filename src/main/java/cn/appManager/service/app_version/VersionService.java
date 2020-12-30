package cn.appManager.service.app_version;

import cn.appManager.pojo.AppVersion;

import java.util.List;

public interface VersionService {
    /**
     * 查询app下的所有version信息
     * @param appId
     * @return
     */
    List<AppVersion> getVersionListByAppId(Integer appId);

    /**
     * 查询App下的版本信息数
     * @param appId
     * @return
     */
    Integer getVersionCountByAppId(Integer appId);

    /**
     * 保存一个version信息
     * @param appVersion
     * @return
     */
    Boolean saveVersion(AppVersion appVersion);

    /**
     * 查询App下的最新版本
     * @param appId
     * @return
     */
    AppVersion getNewVersionByAppId(Integer appId);

    /**
     * 修改version信息
     * @param appVersion
     * @return
     */
    Boolean modifyVersion(AppVersion appVersion);
}
