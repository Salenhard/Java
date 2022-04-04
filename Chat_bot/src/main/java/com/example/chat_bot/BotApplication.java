package com.example.chat_bot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * creates login screen
 */
public class BotApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BotApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 352.0, 434.0);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args argument
     */
    public static void main(String[] args) {
        launch();
    }
}