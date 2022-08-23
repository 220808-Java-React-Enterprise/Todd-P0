package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements CruDAO<Product> {
    @Override
    public void save(Product obj) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO product (productid, productname, productprice, quantity, storeid) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, obj.getProductid());
            ps.setString(2, obj.getProductname());
            ps.setDouble(3, obj.getProductprice());
            ps.setInt(4,obj.getQuantity());
            ps.setString(5,obj.getStoreid());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(Product obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product getById(String id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> prods = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product prod = new Product(rs.getString("productid"), rs.getString("productname"), rs.getDouble("productprice"), rs.getInt("quantity"), rs.getString("store_storeid"));
                prods.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return prods;
    }

    public List<Product> getAllByStoreId(String storeid) {
        List<Product> prodsById = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product WHERE store_storeid = ?");
            ps.setString(1, storeid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product prod = new Product(rs.getString("productid"), rs.getString("productname"), rs.getDouble("productprice"), rs.getInt("quantity"), rs.getString("storeid"));
                prodsById.add(prod);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return prodsById;
    }
}

