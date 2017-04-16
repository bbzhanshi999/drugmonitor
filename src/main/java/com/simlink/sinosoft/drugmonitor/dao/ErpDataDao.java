package com.simlink.sinosoft.drugmonitor.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.common.utils.DateUtils;
import com.simlink.sinosoft.drugmonitor.entity.Query;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface ErpDataDao {

    public List<Map<String,Object>> instoreData(DateUtils.DateRange dateRange);

    public List<Map<String,Object>> instoreData2(Query query);

    public List<Map<String,Object>> outstoreData(DateUtils.DateRange dateRange);

    public List<Map<String,Object>> storageData(DateUtils.DateRange dateRange);

    public List<Map<String,Object>> instoreDataDetail(Query query, PageBounds pageBounds);

    public List<Map<String,Object>> outstoreDataDetail(Query query, PageBounds pageBounds);

    public List<Map<String,Object>> outstoreData2(Query query);

    List<Map<String,Object>> prescriptionData(Query query);
}
