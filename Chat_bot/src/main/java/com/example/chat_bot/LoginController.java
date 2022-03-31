package com.example.chat_bot;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController{
    @FXML
    private TextField loginTextField;
    static String name;

    /**
     * onJoinButtonClick при нажатии устанавливает имя пользлователя и запускает окно чата
     * @throws IOException ?? что-то с stage
     */

    @FXML
    protected void onJoinButtonClick() throws IOException{
        name = loginTextField.getText();
        FXMLLoader fxmlLoader = new FXMLLoader(BotApplication.class.getResource("Chat-view.fxml"));
        Stage stage = new Stage(); //stage object for new window
        Scene scene = new Scene(fxmlLoader.load(), 494.0, 352.0);
        stage.setTitle("ChatBot");
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    /**
     * onJoinEnterPressed при нажатии enter выполняет onJoinButtonClick
     * @param event передаёт events(нажтие клавиш или какие-то манипуляции с окном) передаёт нажатие клавиши enter
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