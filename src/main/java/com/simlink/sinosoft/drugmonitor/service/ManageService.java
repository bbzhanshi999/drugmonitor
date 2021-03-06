package com.simlink.sinosoft.drugmonitor.service;

import com.simlink.common.utils.StringUtils;
import com.simlink.sinosoft.drugmonitor.dao.ManageDao;
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
public class ManageService {

    @Autowired
    private ManageDao inAndOutDao;

    public List<Map<String,Object>> drugInData(Map<String,Object> query) {
        if(StringUtils.isNotBlank((String) query.get("areaName"))){
            return inAndOutDao.drugInDataGroupByArea(query);
        }else{
            return inAndOutDao.drugInData(query);
        }
    }

    public List<Map<String,Object>> drugOutData(Map<String,Object> query) {
        return inAndOutDao.drugOutData(query);
    }


    public List<Map<String,Object>> getDrugNames() {
        return inAndOutDao.getDrugNames();
    }
}
