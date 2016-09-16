package com.simlink.common.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Administrator on 2016/9/16 0016.
 */
public class postProcessAfterInitialization implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if(o instanceof SystemService){
            ((SystemService) o).loadAfterInit();
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
