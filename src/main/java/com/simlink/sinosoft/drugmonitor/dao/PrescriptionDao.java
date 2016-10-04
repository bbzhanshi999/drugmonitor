package com.simlink.sinosoft.drugmonitor.dao;

import com.simlink.common.annotation.MyBatisDao;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface PrescriptionDao {
    List<Map<String,Object>> drugData(Map<String, Object> map);

    List<Map<String,Object>> getDrugNames();

}
