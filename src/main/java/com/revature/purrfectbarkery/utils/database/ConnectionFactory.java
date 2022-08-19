package com.revature.purrfectbarkery.utils.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileReader;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private final Properties properties = new Properties();

    private ConnectionFactory(){
        try{
            properties.load(new FileReader("src/main/resources/db.properties"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) connectionFactory = new ConnectionFactory();
        return connectionFactory;
    }
    public Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        if (connection == null) throw new RuntimeException("Unable to connect to the database!");
        return connection;
    }
}