package com.qxf.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/1
 * @Description: com.qxf.controller
 */
@Controller
public class ShiroController {

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public String doLogin(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            return "登录成功";
        }catch (UnknownAccountException|IncorrectCredentialsException e){
            e.printStackTrace();
            return "账号或密码错误";
        }catch (LockedAccountException e){
            e.printStackTrace();
            return "账号已被锁定，请联系管理员";
        }catch (AuthenticationException e){
            e.printStackTrace();
            return "未知异常，请联系管理员";
        }

    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello:"+SecurityUtils.getSubject().getPrincipal();
    }
}
