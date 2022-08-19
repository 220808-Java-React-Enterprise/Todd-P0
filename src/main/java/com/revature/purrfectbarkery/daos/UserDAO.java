package com.revature.purrfectbarkery.daos;

import com.revature.purrfectbarkery.models.User;
import com.revature.purrfectbarkery.utils.database.ConnectionFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements CruDAO<User>{


    @Override
    public void save(User obj) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (id, username, password, name, email, role) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getPassword());
            ps.setString(4, obj.getName());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getRole());

        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
    }

    @Override
    public void update(User obj) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public String getUsername(String username) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT (username) FROM users WHERE username = ?")
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("username");
        } catch (SQLException e) {
            throw new RuntimeException("An error occurred when trying to save to the database.");
        }
        return null;
    }
    public List<String> getAllUsernames() {
        return null;
    }
}
