package com.simlink.common.security;

import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.SessionCacheUtils;
import com.simlink.common.utils.UserUtils;
import com.simlink.common.web.ValidateCodeServlet;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
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

    /**
     * 权限控制方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String princial = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User u = (User) SessionCacheUtils.getHttpSession().getAttribute("user");
        User currentUser = UserUtils.getCurrentUser();
        for(String role:currentUser.getRoleNames()){
            info.addRole(role);
        }
        for(String menu:currentUser.getMenuNames()){
            info.addStringPermission(menu);
        }

        return info;
    }

    /**
     * 登录验证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Session session1 = SecurityUtils.getSubject().getSession();
        String code = (String)session1.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
        if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){
            throw new IncorrectCredentialsException("msg:验证码错误, 请重试.");
        }
        String userName =token.getUsername();
        User user = systemService.getUser(userName);
        if(user==null){
            throw new UnknownAccountException("无用户信息，请检查用户输入是否正确。");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, user.getPassword(), ByteSource.Util.bytes(userName + user.getSalt()), this.getName());
        return info;
    }


}
