package com.revature.purrfectbarkery.models;

public class OrderHistory {

    private String orderId;

    private String date;

    private String users_Id;

    public OrderHistory() {
    }

    public OrderHistory(String orderId, String date, String users_Id) {
        this.orderId = orderId;
        this.date = date;
        this.users_Id = users_Id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsers_Id() {
        return users_Id;
    }

    public void setUsers_Id(String users_Id) {
        this.users_Id = users_Id;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "orderId='" + orderId + '\'' +
                ", date='" + date + '\'' +
                ", users_Id='" + users_Id + '\'' +
                '}';
    }
}
