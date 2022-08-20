package com.revature.purrfectbarkery.models;

public class Store {
    private String storeid;
    private String storeName;
    private String storeLocation;

    public Store (){

    }

    public Store(String storeid, String storeName, String storeLocation) {
        this.storeid = storeid;
        this.storeName = storeName;
        this.storeLocation = storeLocation;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storeLocation='" + storeLocation + '\'' +
                '}';
    }
}
