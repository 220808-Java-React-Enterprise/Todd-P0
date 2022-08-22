package com.revature.purrfectbarkery.models;

public class Cart {

    private String cardid;

    private String product_ProductId;

    private String orderHistory_OrderId;

    private int cartPrice;

    private int quantity;

    private String users_Id;

    public Cart() {
    }

    public Cart(String cardid, String product_ProductId, String orderHistory_OrderId, int cartPrice, int quantity, String users_Id) {
        this.cardid = cardid;
        this.product_ProductId = product_ProductId;
        this.orderHistory_OrderId = orderHistory_OrderId;
        this.cartPrice = cartPrice;
        this.quantity = quantity;
        this.users_Id = users_Id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getProduct_ProductId() {
        return product_ProductId;
    }

    public void setProduct_ProductId(String product_ProductId) {
        this.product_ProductId = product_ProductId;
    }

    public String getOrderHistory_OrderId() {
        return orderHistory_OrderId;
    }

    public void setOrderHistory_OrderId(String orderHistory_OrderId) {
        this.orderHistory_OrderId = orderHistory_OrderId;
    }

    public int getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(int cartPrice) {
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
                "cardid='" + cardid + '\'' +
                ", product_ProductId='" + product_ProductId + '\'' +
                ", orderHistory_OrderId='" + orderHistory_OrderId + '\'' +
                ", cartPrice=" + cartPrice +
                ", quantity=" + quantity +
                ", users_Id='" + users_Id + '\'' +
                '}';
    }
}
