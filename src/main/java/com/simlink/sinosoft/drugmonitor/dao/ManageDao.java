package com.simlink.sinosoft.drugmonitor.dao;

import com.simlink.common.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface ManageDao {
    List<Map<String,Object>> drugInData(Map<String,Object> map);

    List<Map<String,Object>> drugOutData(Map<String,Object> map);

    List<Map<String,Object>> getDrugNames();

    List<Map<String,Object>> drugInDataGroupByArea(Map<String, Object> query);
}
