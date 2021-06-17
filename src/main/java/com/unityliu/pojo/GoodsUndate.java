package com.unityliu.pojo;

import java.util.HashMap;

public class GoodsUndate {
    private String employeeAccount;
    private String goodsId;
    private String goodsQuantity;
    private String goodsDamageQuantity;
    private String operationKind;
    private String updateTime;

    public HashMap getParamsByName(){
        HashMap map = new HashMap();
        map.put("employee_account",employeeAccount);
        map.put("goods_id",goodsId);
        map.put("goods_quantity",goodsQuantity);
        map.put("goods_damage_quantity",goodsDamageQuantity);
        map.put("operation_kind",operationKind);
        map.put("update_time",updateTime);
        return map;
    }

    //构造函数
    public GoodsUndate() {
    }
    public GoodsUndate(String employeeAccount, String goodsId, String goodsQuantity, String goodsDamageQuantity, String operationKind, String updateTime) {
        this.employeeAccount = employeeAccount;
        this.goodsId = goodsId;
        this.goodsQuantity = goodsQuantity;
        this.goodsDamageQuantity = goodsDamageQuantity;
        this.operationKind = operationKind;
        this.updateTime = updateTime;
    }

    //get和set
    public String getEmployeeAccount() {
        return employeeAccount;
    }
    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }
    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsQuantity() {
        return goodsQuantity;
    }
    public void setGoodsQuantity(String goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }
    public String getGoodsDamageQuantity() {
        return goodsDamageQuantity;
    }
    public void setGoodsDamageQuantity(String goodsDamageQuantity) {
        this.goodsDamageQuantity = goodsDamageQuantity;
    }
    public String getOperationKind() {
        return operationKind;
    }
    public void setOperationKind(String operationKind) {
        this.operationKind = operationKind;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
