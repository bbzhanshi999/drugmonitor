package com.simlink.common.web;

import com.google.common.collect.Maps;
import com.simlink.common.entity.Menu;
import com.simlink.common.entity.User;
import com.simlink.common.service.SystemService;
import com.simlink.common.utils.StringUtils;
import com.simlink.common.utils.UserUtils;
import com.simlink.common.utils.ValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/12 0012.
 */
@Controller
public class LoginController {

    @Value("${defaultPath}")
    private String defaultPath;

    @Value("${loginSuccess}")
    private String loginSuccess;

    @Autowired
    protected SystemService systemService;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登录验证交由shiroFilter完成
     * @return
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest req){
        HashMap<String, Object> map = Maps.newHashMap();
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotBlank(principal)){
            UserUtils.addActiveUser(UserUtils.getUser(principal));
            UserUtils.addActiveUser(UserUtils.getUser(principal));
            map.put("success",true);
            map.put("url",defaultPath);
            return map;
        }
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名不存在";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "验证码输入错误";
        } else if(AuthenticationException.class.getName().equals(exceptionClassName)) {
            error = "密码输入错误";
        }else{
            error = "系统错误，请尝试重新登录";
        }
        map.put("error",error);
        return map;
    }

    /**
     * 登录成功后跳转
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value="${loginSuccess}")
    @ResponseBody
    public Map<String,Object> loginSuccess(HttpServletRequest request, HttpServletResponse response, Model model){
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("success",true);
        map.put("url",defaultPath);
        return map;
    }


    /**
     * 进入主页面
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "${defaultPath}")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model){
        List<Menu> origin = UserUtils.getCurrentUser().getMenus();
        List<Menu> menus = Menu.buildList(origin);
        model.addAttribute("menu",menus);
        return "index";
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

    /**
     * 测试权限
     */
    /*@RequiresPermissions("permission:role")
    @RequestMapping("/authTest")
    public void authTest(HttpSession session){
        System.out.println(session.getAttribute("user"));
    }*/

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/getvcode", method = RequestMethod.GET)
    public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {

        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        HttpSession session = request.getSession();

        ValidateCode vCode = new ValidateCode(80, 36, 4, 20);
        session.setAttribute("validateCode", vCode.getCode());
       /* Session session1 = SecurityUtils.getSubject().getHttpSession();
        session1.setAttribute("validateCode", vCode.getCode());*/
        try {
            vCode.write(response.getOutputStream());
        } catch (IOException e) {
            logger.error(e.toString(),e);
        }
    }
}
