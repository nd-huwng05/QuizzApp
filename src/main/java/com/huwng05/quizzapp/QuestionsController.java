package com.huwng05.quizzapp;

import com.huwng05.pojo.Category;
import com.huwng05.services.CategoryServices;
import com.huwng05.utils.JdbcConnector;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuestionsController implements Initializable {
    @FXML
    private ComboBox<Category> cbCates;
    private static final CategoryServices cateServices = new CategoryServices();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
