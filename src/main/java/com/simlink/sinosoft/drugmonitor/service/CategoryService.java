package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.common.utils.DateUtils;
import com.simlink.sinosoft.drugmonitor.dao.CategoryDao;
import com.simlink.sinosoft.drugmonitor.dao.ErpDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 数据处理service
 * Created by Administrator on 2016/10/3 0003.
 */
@Service
@Transactional(readOnly = true)
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Map<String,Object>> outData(Map<String,Object> query) {
        return categoryDao.outData(query);
    }

    public List<Map<String,Object>> supplyData(Map<String,Object> query) {
        return categoryDao.supplyData(query);
    }
}
