package cn.appManager.dao.app_version;

import cn.appManager.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionMapper {
    /**
     * 查询app下的所有version信息
     * @param appId
     * @return
     */
    List<AppVersion> getVersionListByAppId(@Param("appId")Integer appId);

    /**
     * 查询App下的版本信息数
     * @param appId
     * @return
     */
    Integer getVersionCountByAppId(@Param("appId")Integer appId);

    /**
     * 保存一个version信息
     * @param appVersion
     * @return
     */
    Integer saveVersion(AppVersion appVersion);

    /**
     * 查询App下的最新版本
     * @param appId
     * @return
     */
    AppVersion getNewVersionByAppId(@Param("appId")Integer appId);

    /**
     * 修改version信息
     * @param appVersion
     * @return
     */
    Integer modifyVersion(AppVersion appVersion);

    /**
     * 删除App下的versions
     * @param appId
     * @return
     */
    Integer deleteVersionsByAppId(@Param("appId") Integer appId);
}
