package com.simlink.sinosoft.drugmonitor.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.sinosoft.drugmonitor.entity.Area;
import com.simlink.sinosoft.drugmonitor.entity.Organization;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@MyBatisDao
public interface OrganizationDao {
    public List<Organization> findOrganizations(Organization organization, PageBounds pb);

    public void createOrganization(Organization organization);

    public void updateOrganization(Organization organization);

    public void deleteOrganization(String id);

    public List<Organization> findAllOrganizations();
}
