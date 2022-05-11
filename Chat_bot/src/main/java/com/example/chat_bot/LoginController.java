package com.example.chat_bot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * controller for login screen
 */
public class LoginController{
    @FXML
    private TextField loginTextField;
    static String name;

    /**
     * sets name of user and load chat screen
     * @throws IOException if scene is not found
     */

    @FXML
    protected void onJoinButtonClick() throws IOException{
        name = loginTextField.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BotApplication.class.getResource("Chat-view.fxml"));
        Stage stage = new Stage(); //stage object for new window
        Scene scene = new Scene(fxmlLoader.load(), 494.0, 352.0);
        stage.getIcons().add(new Image("file:bot_icon.png"));
        stage.setTitle("ChatBot");
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    /**
     * activates onJoinButtonClick when enter is pressed
     * @param event pressed button or action
     */

    @FXML
    public void onJoinEnterPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            try {
                onJoinButtonClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}