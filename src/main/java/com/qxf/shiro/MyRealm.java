package com.qxf.shiro;

import com.qxf.pojo.User;
import com.qxf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/1
 * @Description: com.qxf.shiro
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User)SecurityUtils.getSubject().getPrincipal();  //获取当前登录的用户信息

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //这里模拟数据库，进行角色和权限的处理
        //这里只是简单模拟，角色使用是用户名，权限是包含用户名的路径
        simpleAuthorizationInfo.addRole(user.getUsername());
        simpleAuthorizationInfo.addStringPermission("/"+user.getUsername());

        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //这里模拟数据库查询用户，根据用户名查询
        User dbUser = userService.getUserByUsername(username);
        if (dbUser == null){
            //账号不存在
            throw new UnknownAccountException();
        }
        if (dbUser.getEnable()==0){
            //账号被锁定
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(dbUser, dbUser.getPassword(), getName());
    }
}
