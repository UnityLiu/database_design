package com.unityliu.servlet;

import com.unityliu.pojo.UserIdentity;
import com.unityliu.utils.Md5Utils;
import com.unityliu.utils.MybatisUtils;
import com.unityliu.utils.SqlServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServices extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login...-------------------------------");
//        System.out.println(req.getParameter("userName"));
//        System.out.println(req.getParameter("userPassword"));
//        System.out.println(req.getParameter("position"));
        req.setCharacterEncoding("utf8");

        //打印传来的参数map中的key以及value
        for(String key:req.getParameterMap().keySet()){
            System.out.println("key:"+key);
        }

        for(String[] value:req.getParameterMap().values()){
            for(String str : value){
                System.out.println("value:"+str);
            }
        }

        boolean flag = SqlServerUtils.selectUser(req.getParameterMap());

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf8");
        if(flag){
            resp.getWriter().print("true");
        }else{
            resp.getWriter().print("false");
        }


    }
}

