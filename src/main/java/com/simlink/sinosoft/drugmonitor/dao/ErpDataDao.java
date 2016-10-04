package com.simlink.sinosoft.drugmonitor.dao;

import com.simlink.common.annotation.MyBatisDao;
import com.simlink.common.utils.DateUtils;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface ErpDataDao {

    public List<Map<String,Object>> instoreData(DateUtils.DateRange dateRange);

    public List<Map<String,Object>> outstoreData(DateUtils.DateRange dateRange);

    public List<Map<String,Object>> storageData(DateUtils.DateRange dateRange);

}
