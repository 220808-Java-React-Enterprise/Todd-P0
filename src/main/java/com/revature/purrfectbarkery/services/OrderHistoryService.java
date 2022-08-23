package com.revature.purrfectbarkery.services;

import com.revature.purrfectbarkery.daos.OrderHistoryDAO;
import com.revature.purrfectbarkery.models.OrderHistory;


import java.util.List;

public class OrderHistoryService {

    private final OrderHistoryDAO orderHistoryDAO;

    public OrderHistoryService(OrderHistoryDAO orderHistoryDAO) {
        this.orderHistoryDAO = orderHistoryDAO;
    }

    public void addOrderHistory(OrderHistory orderHistory){
        orderHistoryDAO.save(orderHistory);
    }

//    public List<Product> getAllProductsByStoreId(String storeid) {
//        return productDAO.getAllByStoreId(storeid);
//    }

    public List<OrderHistory> getAllOrderHistoryByUserId(String users_id){
        return orderHistoryDAO.getAllByUserId(users_id);
    }
}
