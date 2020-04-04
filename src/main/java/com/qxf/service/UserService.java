package com.qxf.service;

import com.qxf.pojo.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/1
 * @Description: com.qxf.service
 */
@Service
public class UserService {

    //用来存储用户信息的map
    private Map<String,User> userInfo = new HashMap<>(3);

    public UserService(){
        //用户信息
        userInfo.put("admin",new User("admin","123",1));
        userInfo.put("sam",new User("sam","123",1));
        userInfo.put("qxf",new User("qxf","123",0));
    }

    //根据用户名，查找用户，模拟数据库查询
    public User getUserByUsername(String username){
        return userInfo.get(username);
    }

    //获取所有的用户
    public Map<String,User> getAllUser(){
        return userInfo;
    }

}
