package cn.appManager.controller;

import cn.appManager.pojo.AppCategory;
import cn.appManager.service.app_category.CategoryService;
import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * APP分类控制层
 */

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Resource
    private CategoryService categoryService;

    /**
     * 异步加载分类列表
     * @param parentId 根据分类父类编号进行查询
     * @return
     */
    @RequestMapping("/getList/{parentId}")
    @ResponseBody
    public String getCategoryList(@PathVariable String parentId){
        LOGGER.info("ajax get category list parentId = "+ parentId +" = = = = =");
        List<AppCategory> categories = categoryService.getCategoryByParentId(Integer.parseInt(parentId));
        return JSON.toJSONString(categories);
    }
}
