package com.example.database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * DataBase application
 * @author Gurbabatov Vladislav
 * @since 21.05.2022
 */
public class DataBaseApplication extends Application {
    /**
     * start
     * @param stage new window
     * @throws IOException if something bad happened
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("dataBase-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Data base");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main
     * @param args args
     */
    public static void main(String[] args) {
        launch();
    }
}