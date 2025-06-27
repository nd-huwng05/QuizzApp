package com.huwng05.utils;

import javafx.scene.control.Alert;

public class MyAlert {
    private static MyAlert instance;
    private Alert alert;
    private MyAlert() {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setTitle("Quizz App");
    }

    public static MyAlert getInstance() {
        if (instance == null) {
            instance = new MyAlert();
        }
        return instance;
    }

    public void showMessage(String header, String content) {
        this.alert.setHeaderText(header);
        this.alert.setContentText(content);
        this.alert.showAndWait();
    }
}
