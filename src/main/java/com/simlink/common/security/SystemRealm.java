package com.simlink.common.security;

import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.SessionCacheUtils;
import com.simlink.common.utils.UserUtils;
import com.simlink.common.web.ValidateCodeServlet;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
@Service
public class SystemRealm extends AuthorizingRealm {

    @Autowired
    protected SystemService systemService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String princial = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User currentUser = UserUtils.getCurrentUser();
        for(String role:currentUser.getRoleNames()){
            info.addRole(role);
        }
        for(String menu:currentUser.getMenuNames()){
            info.addStringPermission(menu);
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        HttpSession session = SessionCacheUtils.getSession();
        String code = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
        if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){
            throw new AuthenticationException("msg:验证码错误, 请重试.");
        }
        String userName =token.getUsername();
        User user = systemService.getUser(userName);
        if(user==null){
            throw new AuthenticationException("无用户信息，请检查用户输入是否正确。");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(userName + user.getSalt()), this.getName());
        return info;
    }


}
