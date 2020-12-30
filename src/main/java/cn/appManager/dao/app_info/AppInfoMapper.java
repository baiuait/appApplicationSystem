package cn.appManager.dao.app_info;

import cn.appManager.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppInfoMapper {
    /**
     * 获取App详细信息列表
     * @param softwareName 软件名
     * @param status 软件状态
     * @param flatformId 所属平台
     * @param categoryLevel1 一级分类
     * @param categoryLevel2 二级分类
     * @param categoryLevel3 三级分类
     * @param currentPageNo 当前页
     * @param pageSize 页大小
     * @return
     */
    List<AppInfo> getAppInfoList(@Param("softwareName")String softwareName,
                                 @Param("status")Integer status,
                                 @Param("flatformId")Integer flatformId,
                                 @Param("categoryLevel1")Integer categoryLevel1,
                                 @Param("categoryLevel2")Integer categoryLevel2,
                                 @Param("categoryLevel3")Integer categoryLevel3,
                                 @Param("currentPageNo")Integer currentPageNo,
                                 @Param("pageSize")Integer pageSize);

    /**
     * 获取符合条件的APP个数
     * @param softwareName
     * @param status
     * @param flatformId
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
     * @return
     */
    Integer getAppInfoCount(@Param("softwareName")String softwareName,
                                 @Param("status")Integer status,
                                 @Param("flatformId")Integer flatformId,
                                 @Param("categoryLevel1")Integer categoryLevel1,
                                 @Param("categoryLevel2")Integer categoryLevel2,
                                 @Param("categoryLevel3")Integer categoryLevel3);

    /**
     * 添加App信息
     * @param appInfo
     * @return
     */
    Integer saveAppInfo(AppInfo appInfo);

    /**
     * 根据编号获取对应的AppInfo
     * @param id
     * @return
     */
    AppInfo getAppInfoById(@Param("id")Integer id);

    /**
     * 修改AppInfo
     * @param appInfo
     * @return
     */
    Integer modifyAppInfoById(AppInfo appInfo);

    /**
     * 修改App版本
     * @param appVersion
     * @param id
     * @return
     */
    Integer modifyAppVersionById(@Param("appVersion")Integer appVersion, @Param("id")Integer id);

    /**
     * 删除AppInfo
     * @param id
     * @return
     */
    Integer deleteAppInfoById(@Param("id")Integer id);

    /**
     * 修改app状态
     * @param id
     * @param status
     * @return
     */
    Integer modifyAppStatusById(@Param("id")Integer id, @Param("status")Integer status);
}
