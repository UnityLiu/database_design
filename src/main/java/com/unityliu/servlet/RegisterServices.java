package com.unityliu.servlet;

import com.unityliu.pojo.UserIdentity;
import com.unityliu.utils.Md5Utils;
import com.unityliu.utils.SqlServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServices extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(req.getParameter("userName")+"\n"+ req.getParameter("password01")+"\n"+ req.getParameter("position"));
        req.setCharacterEncoding("utf8");


          for(String key:req.getParameterMap().keySet()){
              System.out.println("key:"+key);
          }

        for(String[] value:req.getParameterMap().values()){
            for(String str : value){
                System.out.println("value:"+str);
            }
        }
        boolean flag = SqlServerUtils.addUser(req.getParameterMap());


        if (flag){
            resp.getWriter().print("true");
        }else{
            resp.getWriter().print("false");
        }

    }
}
