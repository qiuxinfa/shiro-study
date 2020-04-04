package com.qxf.controller;

import com.qxf.pojo.User;
import com.qxf.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/1
 * @Description: com.qxf.controller
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUser")
    @RequiresRoles("admin")    //表示需要有[admin]这个角色才可以访问
    @RequiresPermissions("/admin") //表示需要有 /admin 权限才可以访问
    public Collection<User>  allUser(){
        List<User> list = new ArrayList<>();
        Map<String,User> userMap = userService.getAllUser();
        return userMap.values();
    }
}
