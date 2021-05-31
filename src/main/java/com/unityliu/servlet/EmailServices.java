package com.unityliu.servlet;

import com.unityliu.utils.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class EmailServices extends HttpServlet {
    private String verificationCode =null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SendEmail email = new SendEmail();

//        resp.setContentType("test/html");
        resp.setCharacterEncoding("utf-8");

        String receiveMailAccount = req.getParameter("sendEmail");


        verificationCode  =SendEmail.getVerificationCode();

        email.setInfo(verificationCode);
        email.setReceiveMailAccount(receiveMailAccount);

        System.out.println("GET:"+verificationCode);

        if(receiveMailAccount == null){
            resp.getWriter().print("false");
            return;
        }
        try {
            email.Send();
            resp.getWriter().print("true");
        } catch (Exception e) {
            resp.getWriter().print("false");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST:"+verificationCode);
        resp.setCharacterEncoding("utf8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf8");
        String verCode = req.getParameter("verCode");
        //验证验证码是否正确
        if(verCode.equals(verificationCode)){
            resp.getWriter().print("true");
        }else{
            resp.getWriter().print("false");
        }

    }
}
