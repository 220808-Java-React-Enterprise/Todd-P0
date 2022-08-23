package com.revature.purrfectbarkery.models;

public class Inventory {
    private String product_ProductId;
    private String store_StoreId;
    private int quantity;

    public Inventory() {
    }

    public Inventory(String product_ProductId, String store_StoreId, int quantity) {
        this.product_ProductId = product_ProductId;
        this.store_StoreId = store_StoreId;
        this.quantity = quantity;
    }

    public String getProduct_ProductId() {
        return product_ProductId;
    }

    public void setProduct_ProductId(String product_ProductId) {
        this.product_ProductId = product_ProductId;
    }

    public String getStore_StoreId() {
        return store_StoreId;
    }

    public void setStore_StoreId(String store_StoreId) {
        this.store_StoreId = store_StoreId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product_ProductId='" + product_ProductId + '\'' +
                ", store_StoreId='" + store_StoreId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
