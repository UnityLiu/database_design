package com.unityliu.mybatis.dao;

import com.unityliu.pojo.UserIdentity;

import java.util.List;

public interface UserMapper {
    //检查数据库中有无此用户
    UserIdentity getLoginResult(UserIdentity userIdentity);
    //数据库中注册用户
    void addUser(UserIdentity userIdentity);
    //检查数据库中有无此用户名
    String checkUserName(String str);
}
