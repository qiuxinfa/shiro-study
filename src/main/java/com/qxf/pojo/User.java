package com.qxf.pojo;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/4/1
 * @Description: com.qxf.pojo
 */
public class User {
    private String username;
    private String password;
    private Integer enable;  //账号是否锁定

    public User(){}

    public User(String username, String password, Integer enable) {
        this.username = username;
        this.password = password;
        this.enable = enable;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enable=" + enable +
                '}';
    }
}
