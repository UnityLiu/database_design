package com.unityliu.mybatis.dao;

import com.unityliu.pojo.Goods;
import com.unityliu.pojo.GoodsUndate;
import com.unityliu.pojo.UserIdentity;
import com.unityliu.pojo.Warehouse;

import java.util.List;

public interface UserMapper {
    //检查数据库中有无此用户
    UserIdentity getLoginResult(UserIdentity userIdentity);
    //数据库中注册用户
    void addUser(UserIdentity userIdentity);
    //检查数据库中有无此用户名
    String checkUserName(String str);

    //获取数据库employees_table表中所有员工
    List<UserIdentity> getAllEmployees();

    //获取数据库goods_table表中所有商品
    List<Goods> getAllGoods();

    //获取数据库goods_update_table表中所有商品更新信息
    List<GoodsUndate> getAllGoodsUpdate();

    //获取数据库warehouse_table表中所有仓库
    List<Warehouse> getAllWarehouse();

//    void setGoodUpdateQuantity
}
