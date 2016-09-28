package com.simlink.sinosoft.drugmonitor.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.simlink.common.annotation.MyBatisDao;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;

import java.util.List;

@MyBatisDao
public interface DataClientDao {

    public List<DataClient> getAllClients();

    public DataClient getClient(DataClient client);

    public void addClient(DataClient client);

    public void deleteClient(String id);

    public void updateClient(DataClient client);

    public List<DataClient> findClients(DataClient client, PageBounds pb);

    public DataClient getClientById(String id);
}
