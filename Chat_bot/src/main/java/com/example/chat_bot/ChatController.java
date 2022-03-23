package com.example.chat_bot;

import java.io.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ChatController {
    static LoginController s;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private TextField inputTextField;
    private Bot bot;

    public void initialize(){
        bot = new Bot("C:\\Users\\gurba\\IdeaProjects\\Java\\text.txt");
        chatTextArea.appendText(bot.getMessages());
    }

    @FXML
    protected void onSendButtonClick(ActionEvent event) {
        if(!inputTextField.getText().equals("")) {
            bot.addMessage(inputTextField.getText());
            chatTextArea.appendText(s.name + " : " + inputTextField.getText() + "\n");
            chatTextArea.appendText("Бот : " + bot.parseMessage() + "\n");
            inputTextField.setText("");
        }
    }
    @FXML
    protected void onSendKeyPressed(KeyEvent event){

    }

    @Override
    protected void finalize() throws Throwable {

        try(FileWriter writer = new FileWriter("C:\\Users\\gurba\\IdeaProjects\\Java\\text.txt", true))
        {
            writer.write(chatTextArea.getText());
            writer.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        super.finalize();
    }

    //todo сделать сохранение сообщений в файл при закрытии программы
}