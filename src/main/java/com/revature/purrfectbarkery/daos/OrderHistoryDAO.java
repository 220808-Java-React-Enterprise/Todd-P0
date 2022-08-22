package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.OrderHistory;
import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAO implements CruDAO<OrderHistory>{

    @Override
    public void save(OrderHistory obj) {

    }

    @Override
    public void update(OrderHistory obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public OrderHistory getById(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    public List<OrderHistory> getAllByUserId(String users_id) {
        List<OrderHistory> orderHistories = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM orderhistory WHERE users_id = ?");
            ps.setString(1, users_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory(rs.getString("orderid"), rs.getString("date"), rs.getString("users_id"));
                orderHistories.add(orderHistory);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return orderHistories;
    }
}
