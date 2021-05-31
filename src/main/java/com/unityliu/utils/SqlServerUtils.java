package com.unityliu.utils;

import com.unityliu.mybatis.dao.UserMapper;
import com.unityliu.pojo.UserIdentity;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SqlServerUtils {
    static SqlSession sqlSession = null;
    static UserMapper mapper = null;
    static {

        //获取数据库session
        sqlSession = MybatisUtils.getSessionFactory().openSession();
        mapper = sqlSession.getMapper(UserMapper.class);

    }

    public static boolean selectUser(Map<String,String[]> paramMap){
        UserIdentity user = new UserIdentity(paramMap);
        System.out.println(user);
        if(checkUserName(user.getUserName())){
            //登录前检查用户名是否存在
            return false;
        }
        //将登录传来的密码md5加密
        user.setPassword(Md5Utils.stringToMd5(user.getPassword()));
        //userLists数据库获得的数据 user用户传来的数据
        UserIdentity userLists = mapper.getLoginResult(user);
        //输出数据库取出的数据
        System.out.println("name:"+userLists.getUserName()+"\npassword:"+userLists.getPassword()+"\nidentity:"+userLists.getUserIdentity());

        if (userLists.getPassword().equals(user.getPassword()) && userLists.getUserIdentity().equals(user.getUserIdentity())){
            return true;
        }else{
            return false;
        }
    }
    private static boolean checkUserName(String str){
        //用户名存在返回false；不存在返回true
        if (mapper.checkUserName(str)==null)
            return true;
        else
            return false;
    }
    public static boolean addUser(Map<String,String[]> paramMap){
        UserIdentity user = new UserIdentity(paramMap);
        //将用户传来的密码进行md5方式加密后存入数据库
        user.setPassword(Md5Utils.stringToMd5(user.getPassword()));
        //先检查要注册的用户名存不存在，不存在则注册
        if(checkUserName(user.getUserName())){

            mapper.addUser(user);
            //提交事件
            sqlSession.commit();
            return true;
        }else
            return false;
    }
}
