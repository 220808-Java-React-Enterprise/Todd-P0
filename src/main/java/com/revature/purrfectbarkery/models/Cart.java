package com.revature.purrfectbarkery.models;

public class Cart {

    private String cartid;

    private String name;
    private double cartPrice;

    private int quantity;

    private String users_Id;

    public Cart() {
    }

    public Cart(String cartid, String name, double cartPrice, int quantity, String users_Id) {
        this.cartid = cartid;
        this.name = name;
        this.cartPrice = cartPrice;
        this.quantity = quantity;
        this.users_Id = users_Id;
    }

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(String users_Id) {
        this.users_Id = users_Id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartid='" + cartid + '\'' +
                ", name='" + name + '\'' +
                ", cartPrice=" + cartPrice +
                ", quantity=" + quantity +
                ", users_Id='" + users_Id + '\'' +
                '}';
    }
}


