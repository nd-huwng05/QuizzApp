package com.huwng05.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
    private static JdbcConnector instance;
    private final Connection cnn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private JdbcConnector() throws SQLException {
        this.cnn = DriverManager.getConnection("jdbc:mysql://localhost/quizzdb", "root", "root");
    };
    public static JdbcConnector getInstance() throws SQLException {
        if (instance == null) {
            instance = new JdbcConnector();
        }
        return instance;
    }
    public  Connection connection() throws SQLException {
        return this.cnn;
    }

    public void close() throws SQLException {
        if (this.cnn != null) {
                this.cnn.close();
        }
    }
}
