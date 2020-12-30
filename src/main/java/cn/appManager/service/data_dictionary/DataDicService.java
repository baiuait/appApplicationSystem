package cn.appManager.service.data_dictionary;

import cn.appManager.pojo.DataDictionary;

import java.util.List;

public interface DataDicService {
    /**
     * 查询数据
     * @param typeName 数据类型名
     * @return 对应的数据集合
     */
    List<DataDictionary> getDataDictionary(String typeName);
}
