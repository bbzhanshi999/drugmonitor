package com.simlink.sinosoft.drugmonitor.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.utils.StringUtils;
import com.simlink.sinosoft.drugmonitor.dao.AreaDao;
import com.simlink.sinosoft.drugmonitor.dao.DataClientDao;
import com.simlink.sinosoft.drugmonitor.dao.OrganizationDao;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
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
}
