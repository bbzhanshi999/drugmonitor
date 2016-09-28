package com.simlink.sinosoft.drugmonitor.utils;

import com.simlink.common.utils.Collections3;
import com.simlink.common.utils.JedisUtils;
import com.simlink.common.utils.SpringContextHolder;
import com.simlink.common.utils.StringUtils;
import com.simlink.sinosoft.drugmonitor.dao.DataClientDao;
import com.simlink.sinosoft.drugmonitor.entity.DataClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 存取dataClient的工具类
 * Created by Administrator on 2016/9/27 0027.
 */
@Service
@Lazy(false)
public class DataClientUtil {

    protected static Logger logger = LoggerFactory.getLogger(DataClientUtil.class);
    private static final String CLIENTS = "dataClients";
    private static DataClientDao dataClientDao = SpringContextHolder.getBean(DataClientDao.class);

    @PostConstruct
    public static void loadAllClients(){
        List<DataClient> clients = dataClientDao.getAllClients();
        JedisUtils.del(CLIENTS);
        for(DataClient client:clients){
            JedisUtils.hset(CLIENTS,client.getClientName(),client);
        }
    }

    public static DataClient getClient(String clientName){
        DataClient client = (DataClient) JedisUtils.hget(CLIENTS,clientName);
        if(client==null){
            DataClient query = new DataClient();
            query.setClientName(clientName);
            client = dataClientDao.getClient(query);
            if(client!=null && StringUtils.isNotBlank(client.getId())){
                JedisUtils.hset(CLIENTS,clientName,client);
            }
        }
        return client;
    }

    /**
     * 添加client入缓存
     * @param client
     * @param persist 是否持久化数据
     */
    public static void addClient(DataClient client,Boolean persist){
        JedisUtils.hset(CLIENTS,client.getClientName(),client);
        if(persist){
            dataClientDao.addClient(client);
        }
    }

    public static List<DataClient> getAllClients(){
        List<DataClient> clients = JedisUtils.hgetAll(CLIENTS);
        if(Collections3.isEmpty(clients)){
            clients = dataClientDao.getAllClients();
            if(!Collections3.isEmpty(clients)){
                loadAllClients();
            }
        }
        return  clients;
    }

    public static void removeClient(DataClient client) {
        JedisUtils.hdel(CLIENTS,client.getClientName());
    }
}
