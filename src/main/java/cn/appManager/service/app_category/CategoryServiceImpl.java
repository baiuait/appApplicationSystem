package cn.appManager.service.app_category;

import cn.appManager.dao.app_category.CategoryMapper;
import cn.appManager.pojo.AppCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<AppCategory> getCategoryByParentId(Integer parentId) {
        return categoryMapper.getCategoryByParentId(parentId);
    }
}
