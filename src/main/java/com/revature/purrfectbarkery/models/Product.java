package com.revature.purrfectbarkery.models;

public class Product {
    private String productid;
    private String productname;
    private Double productprice;

    private Integer quantity;

    private String storeid;

    public Product() {
    }

    public Product(String productid, String productname, Double productprice, Integer quantity, String storeid) {
        this.productid = productid;
        this.productname = productname;
        this.productprice = productprice;
        this.quantity = quantity;
        this.storeid = storeid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productid + '\'' +
                ", productname='" + productname + '\'' +
                ", productprice=" + productprice +
                ", quantity=" + quantity +
                ", storeid='" + storeid + '\'' +
                '}';
    }
}
