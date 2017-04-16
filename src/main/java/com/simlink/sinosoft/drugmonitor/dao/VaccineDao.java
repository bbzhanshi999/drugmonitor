package com.simlink.sinosoft.drugmonitor.dao;

import com.simlink.common.annotation.MyBatisDao;
import com.simlink.common.utils.DateUtils;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface VaccineDao {

    public List<Map<String,Object>> outData(Map<String,Object> query);

    public List<Map<String,Object>> supplyData(Map<String,Object> query);

}
