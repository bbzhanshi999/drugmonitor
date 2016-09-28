package com.simlink.sinosoft.drugmonitor.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.sinosoft.drugmonitor.dao.AreaDao;
import com.simlink.sinosoft.drugmonitor.dao.DataClientDao;
import com.simlink.sinosoft.drugmonitor.dao.OrganizationDao;
import com.simlink.sinosoft.drugmonitor.entity.Area;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import com.simlink.sinosoft.drugmonitor.entity.Organization;
import com.simlink.sinosoft.drugmonitor.utils.DataClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DataPermissionService {

    @Autowired
    public DataClientDao dataClientDao;

    @Autowired
    public AreaDao areaDao;

    @Autowired
    public OrganizationDao organizationDao;

    /**
     * 查询dataClient
     * @param client
     * @return
     */
    public List<DataClient> getClients(DataClient client,PageBounds pb) {
        return dataClientDao.findClients(client,pb);
    }

    @Transactional(readOnly = false)
    public void createClient(DataClient client) {
        client.preInsert();
        DataClientUtil.addClient(client,true);
    }

    @Transactional(readOnly = false)
    public void updateClient(DataClient client) {
        client.preInsert();
        dataClientDao.updateClient(client);
        DataClientUtil.addClient(client,false);
    }

    @Transactional(readOnly = false)
    public void deleteClient(String id) {
        DataClient query  = new DataClient();
        query.setId(id);
        DataClient client = dataClientDao.getClient(query);
        dataClientDao.deleteClient(id);
        DataClientUtil.removeClient(client);
    }

    public List<Area> getAreas(Area area, PageBounds pb) {
        return areaDao.findAreas(area,pb);
    }

    @Transactional(readOnly = false)
    public void createArea(Area area) {
        area.preInsert();
        areaDao.createArea(area);
    }

    @Transactional(readOnly = false)
    public void updateArea(Area area) {
        area.preUpdate();
        areaDao.updateArea(area);
    }

    @Transactional(readOnly = false)
    public void deleteArea(String id) {
        areaDao.deleteArea(id);
    }

    public List<Organization> getOrganization(Organization organization, PageBounds pb) {
        return organizationDao.findOrganizations(organization,pb);
    }

    @Transactional(readOnly = false)
    public void createOrganization(Organization organization) {
        organization.preInsert();
        organizationDao.createOrganization(organization);
    }

    @Transactional(readOnly = false)
    public void updateOrganization(Organization organization) {
        organization.preUpdate();
        organizationDao.updateOrganization(organization);
    }

    @Transactional(readOnly = false)
    public void deleteOrganization(String id) {
        organizationDao.deleteOrganization(id);
    }
}
