package com.simlink.sinosoft.drugmonitor.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.sinosoft.drugmonitor.entity.Query;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface DistributeDao {
    List<Map<String,Object>> drugData(Map<String, Object> map);

    List<Map<String,Object>> getDrugNames();

    List<Map<String,Object>> scanData(Query query);

    List<Map<String,Object>> scanDataDetail(Query query, PageBounds pb);

    List<Map<String,Object>> getScanCycle(String code);

}
