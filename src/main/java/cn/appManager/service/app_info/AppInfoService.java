package cn.appManager.service.app_info;

import cn.appManager.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {
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
    List<AppInfo> getAppInfoList(String softwareName,Integer status,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,
                                 Integer categoryLevel3,Integer currentPageNo,Integer pageSize);

    /**
     * 查询符合条件的APP个数
     * @param softwareName
     * @param status
     * @param flatformId
     * @param categoryLevel1
     * @param categoryLevel2
     * @param categoryLevel3
     * @return
     */
    Integer getAppInfoCount(String softwareName,Integer status,Integer flatformId,Integer categoryLevel1,Integer categoryLevel2,Integer categoryLevel3);

    /**
     * 添加App信息
     * @param appInfo
     * @return
     */
    Boolean saveAppInfo(AppInfo appInfo);

    /**
     * 根据编号获取对应的AppInfo
     * @param id
     * @return
     */
    AppInfo getAppInfoById(Integer id);

    /**
     * 修改AppInfo
     * @param appInfo
     * @return
     */
    Boolean modifyAppInfoById(AppInfo appInfo);

    /**
     * 删除AppInfo
     * @param id
     * @return
     */
    Boolean deleteAppInfoById(Integer id);

    /**
     * 修改app状态
     * @param id
     * @param status
     * @return
     */
    Boolean modifyAppStatusById(Integer id, Integer status);
}
