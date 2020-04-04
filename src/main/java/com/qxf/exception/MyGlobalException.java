package com.qxf.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/2
 * @Description: 定义全局异常处理
 */
@RestControllerAdvice
public class MyGlobalException {

    //表示只捕获AuthorizationException类及其子类异常
    @ExceptionHandler(AuthorizationException.class)
    public String handlerAuthorizationException(AuthorizationException e){
        e.printStackTrace();
        return "你没有权限访问";
    }
}
