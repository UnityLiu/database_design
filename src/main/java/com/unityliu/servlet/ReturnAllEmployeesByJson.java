package com.unityliu.servlet;

import com.unityliu.utils.SqlServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ReturnAllEmployeesByJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");
        ArrayList<String> paramList = new ArrayList<>();

        //设置数据库中要返回的列
        paramList.add("warehouse_id");
        paramList.add("employee_account");
        paramList.add("employee_name");
        paramList.add("employee_gender");
        paramList.add("employee_born_date");
        paramList.add("employee_position");
        paramList.add("employee_salary");

        resp.getWriter().print(SqlServerUtils.getAllEmployees(paramList));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
