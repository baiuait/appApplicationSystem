package cn.appManager.controller;

import cn.appManager.pojo.DataDictionary;
import cn.appManager.service.data_dictionary.DataDicService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典控制层
 */
@Controller
@RequestMapping("/dataDic")
public class DataDicController {
    @Resource
    DataDicService dataDicService;

    /**
     * 异步加载数据字典中的数据 参数为数据类型名
     */
    @RequestMapping("/{typeName}")
    @ResponseBody
    public String loadData(@PathVariable String typeName){
        List<DataDictionary> data = dataDicService.getDataDictionary(typeName);
        return JSON.toJSONString(data);
    }

}
