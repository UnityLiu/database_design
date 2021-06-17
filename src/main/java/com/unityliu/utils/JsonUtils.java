package com.unityliu.utils;

import com.unityliu.pojo.Goods;
import com.unityliu.pojo.GoodsUndate;
import com.unityliu.pojo.UserIdentity;
import com.unityliu.pojo.Warehouse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonUtils {
    private ArrayList<String> paramsList;
    private JSONObject result ;
    public JsonUtils(ArrayList<String> paramsList) {
        initJsonObject();
        this.paramsList = paramsList;
    }
    //初始化Json对象
    private void initJsonObject(){

        result = new JSONObject();
        result.put("code",0);
        result.put("msg","");
        result.put("count",0);
    }


    //根据employees 返回数据库中员工实体类数据的json对象
    public JSONObject getEmployeesJsons(List<UserIdentity> employees){

        result.put("count",employees.size());

        JSONArray dataArray = new JSONArray();

        for (UserIdentity employee : employees) {
            JSONObject dataInnerJson = new JSONObject();

            for (String param : paramsList) {
                dataInnerJson.put(param,employee.getParamsByName().get(param));
                System.out.println(param+"|"+employee.getParamsByName().get(param));
            }
            dataArray.add(dataInnerJson);
        }
        result.put("data",dataArray);

        return result;
    }
    public JSONObject getGoodsJsons(List<Goods> goods){

        result.put("count",goods.size());
        JSONArray dataArray = new JSONArray();
        for (Goods good : goods) {
            JSONObject dataInnerJson = new JSONObject();

            for (String param : paramsList) {
                dataInnerJson.put(param,good.getParamsByName().get(param));
                System.out.println(param+"|"+good.getParamsByName().get(param));
            }
            dataArray.add(dataInnerJson);
        }
        result.put("data",dataArray);

        return result;
    }
    public JSONObject getGoodsUpdateJsons(List<GoodsUndate> goodsUpdates){
        result.put("count",goodsUpdates.size());
        JSONArray dataArray = new JSONArray();
        for (GoodsUndate goodsUndate : goodsUpdates) {
            JSONObject dataInnerJson = new JSONObject();

            for (String param : paramsList) {
                dataInnerJson.put(param,goodsUndate.getParamsByName().get(param));
                System.out.println(param+"|"+goodsUndate.getParamsByName().get(param));
            }
            dataArray.add(dataInnerJson);
        }
        result.put("data",dataArray);
        return result;
    }
    public JSONObject getWarehouseJsons(List<Warehouse> warehouses){
        result.put("count",warehouses.size());
        JSONArray dataArray = new JSONArray();
        for (Warehouse warehouse : warehouses) {
            JSONObject dataInnerJson = new JSONObject();

            for (String param : paramsList) {
                dataInnerJson.put(param,warehouse.getParamsByName().get(param));
                System.out.println(param+"|"+warehouse.getParamsByName().get(param));
            }
            dataArray.add(dataInnerJson);
        }
        result.put("data",dataArray);
        return result;
    }

}
