package com.unityliu.servlet;

import com.unityliu.utils.SqlServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ReturnAllGoodsUpdateByJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");
        ArrayList<String> paramList = new ArrayList<>();

        //设置数据库中要返回的列
        paramList.add("employee_account");
        paramList.add("goods_id");
        paramList.add("goods_quantity");
        paramList.add("goods_damage_quantity");
        paramList.add("operation_kind");
        paramList.add("update_time");

        resp.getWriter().print(SqlServerUtils.getAllGoodsUpdate(paramList));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
