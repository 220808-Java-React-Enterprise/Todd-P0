package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.Cart;
import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements CruDAO<Cart> {

    @Override
    public void save(Cart obj) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cart (cartid, name, cartprice, quantity, users_id) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getCartid());
            ps.setString(2,obj.getName());
            ps.setDouble(3, obj.getCartPrice());
            ps.setInt(4, obj.getQuantity());
            ps.setString(5, obj.getUsers_Id());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }

    }

    @Override
    public void update(Cart obj) {
//        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
//            PreparedStatement ps = connection.prepareStatement("UPDATE cart SET name = ?, cartprice = ?, quantity = ? WHERE users_id =?");
//            ps.setString(1,obj.getName());
//            ps.setDouble(2, obj.getCartPrice());
//            ps.setInt(3, obj.getQuantity());
//            ps.setString(4, obj.getUsers_Id());
//
//            ps.executeUpdate();
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("An error occurred when trying to save to the database.");
//        }
    }

    @Override
    public void delete(String id) {

    }


    public void deleteCart(String id) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM cart WHERE users_id = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to delete the cart");
        }
    }

        @Override
    public Cart getById(String users_Id) {
            Cart cartByID = new Cart();

            try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart WHERE users_id = ?");
                ps.setString(1, users_Id);
                ps.executeQuery();

            } catch (SQLException e) {
                throw new RuntimeException("An error occurred when trying to save to the database.");
            }
            return cartByID;
    }

    @Override
    public List getAll() {
        List<Cart> cartList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart");
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Cart cart = new Cart(rs.getString("cartid"), rs.getString("name"), rs.getInt("cartprice"), rs.getInt("quantity"), rs.getString("users_id"));
                cartList.add(cart);
            }

        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }

        return cartList;
    }
    public List<Cart> getAllCartByUserId(String users_Id) {
        List<Cart> cartFull = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart WHERE users_id = ?");
            ps.setString(1, users_Id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cart cartLoad = new Cart(rs.getString("cartid"), rs.getString("name"), rs.getInt("cartprice"), rs.getInt("quantity"), rs.getString("users_id"));
                cartFull.add(cartLoad);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return cartFull;
    }
}
