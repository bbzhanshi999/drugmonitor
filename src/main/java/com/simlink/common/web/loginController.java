package com.simlink.common.web;


import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.SessionCacheUtils;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by Administrator on 2016/2/12 0012.
 */
@Controller
public class loginController {

    @Value("${defaultPath}")
    private String defaultPath;
    @Autowired
    protected SystemService systemService;

    private static Logger logger = LoggerFactory.getLogger(loginController.class);

    /**
     * 登录验证交由shiroFilter完成
     * @return
     */
    @RequestMapping(value="/login")
    public String login(){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotBlank(principal)){
            UserUtils.addActiveUser(UserUtils.getUser(principal));
            UserUtils.addActiveUser(UserUtils.getUser(principal));
            return "redirect:"+defaultPath;
        }else{
            // TODO: 2016/9/16 0016 登录失败
        }
        return "login";
    }

    /**
     * 登录成功后跳转的页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="${defaultPath}",method = RequestMethod.POST)
    public String defaultPath(HttpServletRequest request, HttpServletResponse response, Model model){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("principal",principal);
        return "success";
    }

    /**
     * 注册新账号，并且加密，存入数据库
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/signIn")
    public String signIn(String username,String password){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("md5",password,username+salt,2);
        password= hash.toString();
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setSalt(salt);
        user.preInsert();
        systemService.createUser(user);

        return "redirect:login";
    }


    /**
     * 退出登录
     * @return
     */
    public String logout(){
        SecurityUtils.getSubject().logout();
        UserUtils.logoutUser();
        return "redirect:login";
    }
}
