package com.huwng05.quizzapp;

import com.huwng05.utils.MyAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class PrimaryController {
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("questions.fxml")).load());
        Stage stage = new Stage();
        stage.setTitle("QuizzApp");
        stage.setScene(scene);
        stage.show();
    }
    public void handlePractice(ActionEvent event) {
        MyAlert.getInstance().showMessage("Practice", "Coming soon!");
    }
}
