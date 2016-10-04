package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.sinosoft.drugmonitor.dao.DistributeDao;
import com.simlink.sinosoft.drugmonitor.dao.PrescriptionDao;
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
public class PrescriptionService {

    @Autowired
    private PrescriptionDao prescriptionDao;

    public List<Map<String,Object>> drugData(Map<String,Object> query) {
        return prescriptionDao.drugData(query);
    }

    public List<Map<String,Object>> getDrugNames() {
        return prescriptionDao.getDrugNames();
    }
}
