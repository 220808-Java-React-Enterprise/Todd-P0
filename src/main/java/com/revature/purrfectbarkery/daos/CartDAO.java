package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.Cart;
import com.revature.purrfectbarkery.models.OrderHistory;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CruDAO<Cart>{

    @Override
    public void save(Cart obj) {

    }

    @Override
    public void update(Cart obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Cart getById(String id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
    public List<Cart> getAllCartByUserId(String users_Id) {
        List<Cart> cartFull = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart WHERE users_id = ?");
            ps.setString(6, users_Id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cartLoad = new Cart(rs.getString("cartid"), rs.getString("product_productid"), rs.getString("orderhistory_orderid"), rs.getInt("cartPrice"), rs.getInt("quantity"), rs.getString("users_id"));
                cartFull.add(cartLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return cartFull;
    }
}
