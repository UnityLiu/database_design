package com.unityliu.servlet;

import com.unityliu.utils.SqlServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ReturnAllGoodsByJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf8");
        ArrayList<String> paramList = new ArrayList<>();

        //设置数据库中要返回的列
        paramList.add("goods_id");
        paramList.add("goods_name");
        paramList.add("warehouse_id");
        paramList.add("goods_supplier");
        paramList.add("goods_kind");
        paramList.add("goods_purchase_price");
        paramList.add("goods_selling_price");
        paramList.add("goods_inventory");

        String warehouseId = new String();


        //通过cookie获取当前员工负责的仓库编号
        for (Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals("warehouse_id")){
                warehouseId =  cookie.getValue();
                System.out.println(warehouseId);
                break;
            }
        }

        resp.getWriter().print(SqlServerUtils.getAllGoods(paramList,warehouseId));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
