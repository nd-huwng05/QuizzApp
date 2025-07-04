package com.huwng05.services;

import com.huwng05.pojo.Category;
import com.huwng05.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryServices {
    public List<Category> getCates() throws SQLException {
        Connection cnn = JdbcConnector.getInstance().connect();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery("select * from category");
        List<Category> cates = new ArrayList<>();
        while (rs.next()) {
            cates.add(new Category(rs.getInt("id"), rs.getString("name")));
        }
        return cates;
    }
}
