package com.simlink.common.security;

import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.UserUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Autowired
    protected SystemService systemService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String userName = (String) token.getPrincipal();
        // TODO: 2016/9/14 0014 实现五次输入错误就记录超时的功能
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            User user = UserUtils.getUser(userName);
            UserUtils.addActiveUser(user);
        }
        return matches;
    }
}
