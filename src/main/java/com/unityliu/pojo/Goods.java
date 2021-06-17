package com.unityliu.pojo;

import java.util.HashMap;

public class Goods {
    private String goodsId;
    private String goodsName;
    private String warehouseId;
    private String goodsSupplier;
    private String goodsKind;
    private String goodsPurchasePrice;
    private String goodsSellingPrice;
    private String goodsInventory;

    public HashMap getParamsByName(){
        HashMap map = new HashMap();
        map.put("goods_id",goodsId);
        map.put("goods_name",goodsName);
        map.put("warehouse_id",warehouseId);
        map.put("goods_supplier",goodsSupplier);
        map.put("goods_kind",goodsKind);
        map.put("goods_purchase_price",goodsPurchasePrice);
        map.put("goods_selling_price",goodsSellingPrice);
        map.put("goods_inventory",goodsInventory);
        return map;
    }


    //构造函数
    public Goods() {
    }
    public Goods(String goodsId, String goodsName, String warehouseId, String goodsSupplier, String goodsKind, String goodsPurchasePrice, String goodsSellingPrice, String goodsInventory) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.warehouseId = warehouseId;
        this.goodsSupplier = goodsSupplier;
        this.goodsKind = goodsKind;
        this.goodsPurchasePrice = goodsPurchasePrice;
        this.goodsSellingPrice = goodsSellingPrice;
        this.goodsInventory = goodsInventory;
    }

    //get和set
    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
    public String getGoodsSupplier() {
        return goodsSupplier;
    }
    public void setGoodsSupplier(String goodsSupplier) {
        this.goodsSupplier = goodsSupplier;
    }
    public String getGoodsKind() {
        return goodsKind;
    }
    public void setGoodsKind(String goodsKind) {
        this.goodsKind = goodsKind;
    }
    public String getGoodsPurchasePrice() {
        return goodsPurchasePrice;
    }
    public void setGoodsPurchasePrice(String goodsPurchasePrice) {
        this.goodsPurchasePrice = goodsPurchasePrice;
    }
    public String getGoodsSellingPrice() {
        return goodsSellingPrice;
    }
    public void setGoodsSellingPrice(String goodsSellingPrice) {
        this.goodsSellingPrice = goodsSellingPrice;
    }
    public String getGoodsInventory() {
        return goodsInventory;
    }
    public void setGoodsInventory(String goodsInventory) {
        this.goodsInventory = goodsInventory;
    }



}
