package com.revature.purrfectbarkery.models;

public class Product {
    private String productid;
    private String productname;
    private Integer productprice;

    public Product() {
    }

    public Product(String productid, String productname, Integer productprice) {
        this.productid = productid;
        this.productname = productname;
        this.productprice = productprice;
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

    public Integer getProductprice() {
        return productprice;
    }

    public void setProductprice(Integer productprice) {
        this.productprice = productprice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid='" + productid + '\'' +
                ", productname='" + productname +
                ", productprice=" + productprice +
                '}';
    }
}
