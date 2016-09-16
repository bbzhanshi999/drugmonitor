package com.simlink.common.service;

import com.simlink.common.dao.SystemDao;
import com.simlink.common.entity.User;
import com.simlink.common.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统服务类
 * Created by Administrator on 2016/9/14 0014.
 */
@Service
@Transactional(readOnly = true)
public class SystemService {

    @Autowired
    public SystemDao systemDao;

    /**
     * 容器加载完后，将权限数据注入缓存
     */
    public void loadAfterInit(){
        UserUtils.loadAllUsers();
    }

    /**
     * 根据用户名取得用户信息
     * @param userName
     * @return
     */
    @Transactional(readOnly = false)
    public User getUser(String userName){
        User user = UserUtils.getUser(userName);
        return user;
    }

    /**
     * 添加新用户
     * @param user
     */
    @Transactional(readOnly = false)
    public void createUser(User user) {
        UserUtils.addUser(user,true);
    }
}
