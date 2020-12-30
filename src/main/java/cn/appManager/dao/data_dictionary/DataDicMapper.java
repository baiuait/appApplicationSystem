package cn.appManager.dao.data_dictionary;

import cn.appManager.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 查询数据字典中的数据
 */
@Repository
public interface DataDicMapper {
    /**
     * 查询数据
     * @param typeName 数据类型名
     * @return 对应的数据集合
     */
    List<DataDictionary> getDataDictionary(@Param("typeName") String typeName);

}
