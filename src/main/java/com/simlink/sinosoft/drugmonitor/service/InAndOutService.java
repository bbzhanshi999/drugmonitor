package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.common.utils.DateUtils;
import com.simlink.sinosoft.drugmonitor.dao.InAndOutDao;
import org.omg.CORBA.PUBLIC_MEMBER;
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
public class InAndOutService {

    @Autowired
    private InAndOutDao inAndOutDao;

    public List<Map<String,Object>> drugInData(Map<String,Object> query) {
        return inAndOutDao.drugInData(query);
    }

    public List<Map<String,Object>> drugOutData(Map<String,Object> query) {
        return inAndOutDao.drugOutData(query);
    }


    public List<Map<String,Object>> getDrugNames() {
        return inAndOutDao.getDrugNames();
    }
}
