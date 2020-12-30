package cn.appManager.service.data_dictionary;

import cn.appManager.dao.data_dictionary.DataDicMapper;
import cn.appManager.pojo.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDicServiceImpl implements DataDicService {
    @Resource
    private DataDicMapper dataDicMapper;

    @Override
    public List<DataDictionary> getDataDictionary(String typeName) {
        return dataDicMapper.getDataDictionary(typeName);
    }
}
