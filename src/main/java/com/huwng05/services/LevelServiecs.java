/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huwng05.services;

import com.huwng05.pojo.Level;
import com.huwng05.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServiecs {
    public List<Level> getLevels() throws SQLException {
        Connection cnn = JdbcConnector.getInstance().connect();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery("select * from level");
        List<Level> levels = new ArrayList<Level>();
        while (rs.next()) {
            levels.add(new Level(rs.getInt("id"), rs.getString("name"), rs.getString("note")));
        }
        return levels;
    }
}
