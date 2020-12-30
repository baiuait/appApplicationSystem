package cn.appManager.dao.app_category;

import cn.appManager.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {
    /**
     * 获取一个分类下的所有分类
     * @param parentId 父级分类编号
     * @return
     */
    List<AppCategory> getCategoryByParentId(@Param("parentId")Integer parentId);
}
