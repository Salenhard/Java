package com.example.chat_bot;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField loginTextField;
    static String name;
    @FXML
    protected void onJoinButtonClick(ActionEvent actionEvent) throws IOException{
        name = loginTextField.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BotApplication.class.getResource("Chat-view.fxml"));
        Stage stage = new Stage(); //stage object for new window
        Scene scene = new Scene(fxmlLoader.load(), 494.0, 352.0);
        stage.setTitle("ChatBot");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void onRegistrationButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BotApplication.class.getResource("Registration-view.fxml"));
        Stage stage = new Stage(); //stage object for new window
        Scene scene = new Scene(fxmlLoader.load(), 494.0, 352.0);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}