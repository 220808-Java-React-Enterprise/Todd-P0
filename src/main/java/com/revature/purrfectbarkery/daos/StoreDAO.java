package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.Product;
import com.revature.purrfectbarkery.models.Store;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO implements CruDAO {
    @Override
    public void save(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Object getById(String id) {
        return null;
    }

    @Override
    public List getAll() {
        List<Store> stores = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM store");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Store store = new Store(rs.getString("storeid"),rs.getString("storename"),rs.getString("storelocation"));
                stores.add(store);
            }
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return stores;
    }
}
