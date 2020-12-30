package cn.appManager.service.app_category;

import cn.appManager.pojo.AppCategory;

import java.util.List;

public interface CategoryService {
    /**
     * 获取一个分类下的所有分类
     * @param parentId 父级分类编号
     * @return
     */
    List<AppCategory> getCategoryByParentId(Integer parentId);
}
