package com.simlink.sinosoft.drugmonitor.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.simlink.common.utils.DateUtils;
import com.simlink.common.utils.StringUtils;
import com.simlink.sinosoft.drugmonitor.dao.ErpDataDao;

import com.simlink.sinosoft.drugmonitor.dao.OrganizationDao;
import com.simlink.sinosoft.drugmonitor.entity.Organization;
import com.simlink.sinosoft.drugmonitor.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 数据处理service
 * Created by Administrator on 2016/10/3 0003.
 */
@Service
@Transactional(readOnly = true)
public class ErpDataService {
    @Autowired
    private ErpDataDao erpDataDao;
    @Autowired
    private OrganizationDao organizationDao;

    private static Map<String, String> drugtypes = Maps.newHashMap();

    static {
        drugtypes.put("1", "西药");
        drugtypes.put("2", "中药");
        drugtypes.put("3", "草药");
    }

    public List<Map<String, Object>> instoreData(Query query) {
        return erpDataDao.instoreData2(query);
    }

    public List<Map<String, Object>> classifyData(Query query) {
        List<Map<String, Object>> result = Lists.newArrayList();
        for (String key : drugtypes.keySet()) {
            query.setDrugType(key);
            List<Map<String, Object>> maps = instoreData(query);
            Map<String, Object> map = Maps.newHashMap();
            map.put("drugType", drugtypes.get(key));
            map.put("data", maps);
            result.add(map);
        }

        return result;
    }

    public List<Map<String, Object>> outstoreData(Query query) {
        return erpDataDao.outstoreData2(query);
    }


    /**
     * 查询入库明细
     *
     * @param query
     * @return
     */
    public List<Map<String, Object>> instoreDataDetail(Query query, PageBounds pageBounds) {
        DateUtils.DateRange dateRange = null;
        try {
            dateRange = DateUtils.getDateRange(query.getIndex(), query.getPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        query.setStartDate(dateRange != null ? dateRange.getStartDate() : null);
        query.setEndDate(dateRange != null ? dateRange.getEndDate() : null);

        return erpDataDao.instoreDataDetail(query, pageBounds);
    }

    /**
     * 查询出库明细
     *
     * @param query
     * @return
     */
    public List<Map<String, Object>> outstoreDataDetail(Query query, PageBounds pb) {
        DateUtils.DateRange dateRange = null;
        try {
            dateRange = DateUtils.getDateRange(query.getIndex(), query.getPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        query.setStartDate(dateRange != null ? dateRange.getStartDate() : null);
        query.setEndDate(dateRange != null ? dateRange.getEndDate() : null);

        return erpDataDao.outstoreDataDetail(query, pb);
    }

    /**
     * 获得药品采购汇总统计数据
     *
     * @param query
     * @return
     */
    public List<Map<String, Object>> purchaseData(Query query) {
        List<Map<String, Object>> result = Lists.newArrayList();
        List<Organization> organizations = Lists.newArrayList();
        String[] institution = StringUtils.isBlank(query.getInstitution()) ? organizationDao.getAllOrganId() : query.getInstitution().split(",");
        if (StringUtils.isBlank(query.getInstitution())) {
            organizations = organizationDao.findAllOrganizations();
        } else {
            for (String organ : institution) {
                organizations.add(organizationDao.getOrganById(organ));
            }
        }
        for (Organization organ : organizations) {
            query.setInstitution(organ.getId());
            List<Map<String, Object>> maps = instoreData(query);
            Map<String, Object> map = Maps.newHashMap();
            map.put("institution", organ.getOrganName());
            map.put("data", maps);
            result.add(map);
        }
        return result;
    }

    /**
     * 查询处方
     *
     * @param query
     * @return
     */
    public List<Map<String, Object>> prescriptionData(Query query) {
        List<Map<String, Object>> result = Lists.newArrayList();
        List<Organization> organizations = Lists.newArrayList();
        String[] institution = StringUtils.isBlank(query.getInstitution()) ? organizationDao.getAllOrganId() : query.getInstitution().split(",");
        if (StringUtils.isBlank(query.getInstitution())) {
            organizations = organizationDao.findAllOrganizations();
        } else {
            for (String organ : institution) {
                organizations.add(organizationDao.getOrganById(organ));
            }
        }
        for (Organization organ : organizations) {
            query.setInstitution(organ.getId());
            List<Map<String, Object>> maps = erpDataDao.prescriptionData(query);
            Map<String, Object> map = Maps.newHashMap();
            map.put("institution", organ.getOrganName());
            map.put("data", maps);
            result.add(map);
        }
        return result;
    }

    public List<Map<String, Object>> surplusData(Query query) {
        return erpDataDao.surplusData(query);
    }

    public List<Map<String, Object>> surplusDataDetail(Query query, PageBounds pb) {
        DateUtils.DateRange dateRange = null;
        try {
            dateRange = DateUtils.getDateRange(query.getIndex(), query.getPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        query.setStartDate(dateRange != null ? dateRange.getStartDate() : null);
        query.setEndDate(dateRange != null ? dateRange.getEndDate() : null);

        return erpDataDao.surplusDataDetail(query, pb);
    }
}
