package com.example.chat_bot;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.io.IOException;

/**
 * controller for chat
 */
public class ChatController {
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField inputTextField;
    private Bot bot;
    private final String fileName = "C:\\Users\\gurba\\IdeaProjects\\Java\\text.txt";

    /**
     * gets data from text file in start of program
     */

    public void initialize(){
        bot = new Bot(fileName);
        chatTextArea.appendText(bot.getMessages());
    }

    /**
     * send meesage to bot and gets answer, saving all messages in text file
     */

    @FXML
    protected void onSendButtonClick() {
        if(!inputTextField.getText().equals("")) {
            bot.addMessage(inputTextField.getText());
            chatTextArea.appendText(LoginController.name + " : " + inputTextField.getText() + "\n");
            chatTextArea.appendText("Бот : " + bot.parseMessage() + "\n");
            try{
                bot.writeFile(fileName, LoginController.name + " : " + inputTextField.getText() + "\n");
                bot.writeFile(fileName, "Бот : " + bot.message.get(bot.message.size() - 1) + "\n");
            }
            catch (IOException e){
                e.printStackTrace();
            }
            inputTextField.setText("");
        }
    }

    /**
     * calls onSendButtonClick when pressed enter
     * @param event pressed button or another action
     */

    @FXML
    protected void onSendKeyPressed(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER)
            onSendButtonClick();
    }

}