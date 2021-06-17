package com.unityliu.pojo;

import java.util.HashMap;

public class Warehouse {
    private String warehouseId;
    private String warehouseAddress;

    public HashMap getParamsByName(){
        HashMap map = new HashMap();
        map.put("warehouse_id",warehouseId);
        map.put("warehouse_address",warehouseAddress);
        return map;
    }

    //构造函数
    public Warehouse() {
    }
    public Warehouse(String warehouseId, String warehouseAddress) {
        this.warehouseId = warehouseId;
        this.warehouseAddress = warehouseAddress;
    }

    //get和set
    public String getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    public String getWarehouseAddress() {
        return warehouseAddress;
    }
    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }



}
