package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.sinosoft.drugmonitor.dao.DistributeDao;
import com.simlink.sinosoft.drugmonitor.dao.SupplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 药品出入
 * Created by Administrator on 2016/10/4 0004.
 */
@Service
@Transactional(readOnly = true)
public class DistributeService {

    @Autowired
    private DistributeDao distributeDao;

    public List<Map<String,Object>> drugData(Map<String,Object> query) {
        return distributeDao.drugData(query);
    }

    public List<Map<String,Object>> getDrugNames() {
        return distributeDao.getDrugNames();
    }
}
