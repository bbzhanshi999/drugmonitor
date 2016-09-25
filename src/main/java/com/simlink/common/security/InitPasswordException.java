package com.simlink.common.security;


import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by Administrator on 2016/9/24 0024.
 */
public class InitPasswordException extends AuthenticationException {

    public InitPasswordException(String message) {
        super(message);
    }

    public InitPasswordException(Throwable cause) {
        super(cause);
    }

    public InitPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
