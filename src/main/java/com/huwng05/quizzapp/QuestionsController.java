package com.huwng05.quizzapp;

import com.huwng05.pojo.Category;
import com.huwng05.pojo.Choice;
import com.huwng05.pojo.Level;
import com.huwng05.pojo.Question;
import com.huwng05.services.CategoryServices;
import com.huwng05.services.LevelServiecs;
import com.huwng05.services.QuestionServices;
import com.huwng05.utils.MyAlert;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class QuestionsController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    @FXML private ComboBox<Level> cbLevel;
    @FXML private VBox vBoxChoie;
    @FXML private TextArea txtQuestion;
    @FXML private ToggleGroup toggleChoice = new ToggleGroup();
    private static final CategoryServices cateServices = new CategoryServices();
    private static final LevelServiecs levelServices = new LevelServiecs();
    private static final QuestionServices questionServices = new QuestionServices();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateServices.getCates()));
            this.cbLevel.setItems(FXCollections.observableList(levelServices.getLevels()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addChoice(ActionEvent event) {
        HBox hBox = new HBox();
        hBox.getStyleClass().add("Main");

        RadioButton r = new RadioButton();
        r.setToggleGroup(toggleChoice);
        TextField txt = new TextField();
        txt.getStyleClass().add("Input");

        hBox.getChildren().addAll(r, txt);
        this.vBoxChoie.getChildren().add(hBox);
    }

    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtQuestion.getText(), this.cbCates.getSelectionModel().getSelectedItem()
                    , this.cbLevel.getSelectionModel().getSelectedItem());
            for (var c: vBoxChoie.getChildren()) {
                HBox hBox = (HBox) c;
                Choice choice = new Choice(((TextField)hBox.getChildren().get(1)).getText(),((RadioButton)hBox.getChildren().get(0)).isSelected());
                b.addChoice(choice);
            }

            questionServices.addQuestion(b.build());
            MyAlert.getInstance().showMessage("Successful", "Question added successfully");
        } catch (SQLException e){
            MyAlert.getInstance().showMessage("Error: ", e.getMessage());
        } catch (Exception e) {
            MyAlert.getInstance().showMessage("Error: ", e.getMessage());
        }

    }
}
