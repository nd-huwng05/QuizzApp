package com.huwng05.quizzapp;

import com.huwng05.utils.MyAlert;
import com.huwng05.utils.MyStage;
import com.huwng05.utils.themes.Themes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class PrimaryController implements Initializable{
    @FXML private ComboBox<Themes> cbThemes;
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("questions.fxml");
    }
    public void handlePractice(ActionEvent event) {
        MyAlert.getInstance().showMessage("Practice", "Coming soon!");
    }
    public void changeThemes(ActionEvent event) {
        this.cbThemes.getSelectionModel().getSelectedItem().updateThemes(this.cbThemes.getScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.cbThemes.setItems(FXCollections.observableArrayList(Themes.values()));
    }
}
