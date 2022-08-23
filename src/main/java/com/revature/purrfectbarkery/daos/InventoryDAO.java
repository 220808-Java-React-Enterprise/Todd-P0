package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.Inventory;
import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;
import javafx.scene.transform.NonInvertibleTransformException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO implements CruDAO<Inventory> {
    @Override
    public void save(Inventory obj) {

    }

    @Override
    public void update(Inventory obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Inventory getById(String id) {
        return null;
    }

    @Override
    public List<Inventory> getAll() {
        return null;
    }

    public List<Inventory> getAllByStoreId(String storeid) {

        List<Inventory> invByStoreId = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM inventory WHERE store_storeid = ?");
            ps.setString(2, storeid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inventory inventory = new Inventory(rs.getString("product_productid"), rs.getString("store_storeid"), rs.getInt("quantity"));
                invByStoreId.add(inventory);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return invByStoreId;
    }
    public List<Inventory> getAllByProdId(String productid) {

        List<Inventory> invByProdId = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM inventory WHERE product_productid = ?");
            ps.setString(1, productid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inventory inventory = new Inventory(rs.getString("product_productid"), rs.getString("store_storeid"), rs.getInt("quantity"));
                invByProdId.add(inventory);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return invByProdId;
    }
}
