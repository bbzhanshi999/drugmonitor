package com.simlink.common.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import javax.validation.Validator;

/**
 * 控制器支持类
 * Created by zql on 2016/4/28 0028.
 */
public class BaseController {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator validator;


    /**
     * 配置基本路径,动态改变路径
     */
    @Value("${basePath}")
    protected String basePath;



    /**
     * 添加Model消息
     * @param messages
     */
    protected void addMessage(Model model, String... messages) {
        StringBuilder sb = new StringBuilder();
        for (String message : messages){
            sb.append(message).append(messages.length>1?"<br/>":"");
        }
        model.addAttribute("message", sb.toString());
    }



}
