package com.unityliu.utils;

import com.unityliu.mybatis.dao.UserMapper;
import com.unityliu.pojo.Goods;
import com.unityliu.pojo.GoodsUndate;
import com.unityliu.pojo.UserIdentity;
import com.unityliu.pojo.Warehouse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
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
        if(checkUserName(user.getEmployeeAccount())){
            //登录前检查用户名是否存在
            return false;
        }
        //将登录传来的密码md5加密
        user.setEmployeePassword(Md5Utils.stringToMd5(user.getEmployeePassword()));
        //userLists数据库获得的数据 user用户传来的数据
        UserIdentity userLists = mapper.getLoginResult(user);
        //输出数据库取出的数据
        System.out.println("name:"+userLists.getEmployeeAccount()+"\npassword:"+userLists.getEmployeePassword()+"\nidentity:"+userLists.getEmployeePosition());

        if (userLists.getEmployeePassword().equals(user.getEmployeePassword()) && userLists.getEmployeePosition().equals(user.getEmployeePosition())){
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
        System.out.println("实体类创建成功"+user);
        //将用户传来的密码进行md5方式加密后存入数据库
        user.setEmployeePassword(Md5Utils.stringToMd5(user.getEmployeePassword()));
        //先检查要注册的用户名存不存在，不存在则注册
        if(checkUserName(user.getEmployeeAccount())){
            mapper.addUser(user);
            //提交事件
            sqlSession.commit();
            return true;
        }else
            return false;
    }

    //获取所有employees_table表中所有数据
    public static JSONObject getAllEmployees(ArrayList<String> paramsList){
        List<UserIdentity> employees = mapper.getAllEmployees();
        JsonUtils jsonUtils = new JsonUtils(paramsList);
        return jsonUtils.getEmployeesJsons(employees);
    }

    //获取所有goods_table表中所有数据
    public static JSONObject getAllGoods(ArrayList<String> paramsList,String warehouseId){
        List<Goods> goods = mapper.getAllGoods(warehouseId);
        JsonUtils jsonUtils = new JsonUtils(paramsList);
        return jsonUtils.getGoodsJsons(goods);
    }

    //获取所有goods_update_table表中所有数据
    public static JSONObject getAllGoodsUpdate(ArrayList<String> paramsList){
        List<GoodsUndate> goodsUndates = mapper.getAllGoodsUpdate();
        JsonUtils jsonUtils = new JsonUtils(paramsList);

        return jsonUtils.getGoodsUpdateJsons(goodsUndates);
    }
    //获取所有warehouse_table表中所有数据
    public static JSONObject getAllWarehouse(ArrayList<String> paramsList){
        List<Warehouse> warehouses = mapper.getAllWarehouse();
        JsonUtils jsonUtils = new JsonUtils(paramsList);

        return jsonUtils.getWarehouseJsons(warehouses);
    }

    //根据账户名获取用户数据
    public static UserIdentity getEmployeeByAccount(String account){
        UserIdentity employee = mapper.getEmployeeByAccount(account);
        return employee;
    }
}
