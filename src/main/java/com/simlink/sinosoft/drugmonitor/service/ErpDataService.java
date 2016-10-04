package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.common.utils.DateUtils;
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
public class ErpDataService {
    @Autowired
    private ErpDataDao erpDataDao;

    public List<Map<String,Object>> instoreData(DateUtils.DateRange dateRange) {
        return erpDataDao.instoreData(dateRange);
    }


    public List<Map<String,Object>> outstoreData(DateUtils.DateRange dateRange) {
        return erpDataDao.outstoreData(dateRange);
    }

    public List<Map<String,Object>> storageData(DateUtils.DateRange dateRange) {
        return erpDataDao.storageData(dateRange);
    }
}
