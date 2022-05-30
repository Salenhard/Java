package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * controller for adding new person
 */
public class NewPersonController {

    public Label textFieldError;
    @FXML
    private Button buttonDecline;

    @FXML
    private TextField textFieldAge;

    @FXML
    private TextField textFieldMoney;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldNumber;

    private DataBase dataBase;
    private TableView<Person> objectsTableView;

    /**
     * decline adding new object
     * @param event input event
     */

    @FXML
    void onButtonDeclineClick(ActionEvent event) {
        Stage stage = (Stage) buttonDecline.getScene().getWindow();
        stage.close();
    }

    /**
     * submit all params for new person
     * @param event input event
     */
    @FXML
    void onButtonSubmitClick(ActionEvent event){
        int count = 0;
        textFieldError.setVisible(false);
        Person newPerson = new Person();
        textFieldAge.setStyle("-fx-control-inner-background: white");
        textFieldNumber.setStyle("-fx-control-inner-background: white");
        textFieldMoney.setStyle("-fx-control-inner-background: white");
        textFieldName.setStyle("-fx-control-inner-background: white");
        try {
            newPerson.setName(textFieldName.getText());
        } catch (IOException e){
            e.printStackTrace();
            textFieldName.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldAge.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldAge.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldMoney.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldMoney.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            Integer.parseInt(textFieldNumber.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textFieldNumber.setStyle("-fx-control-inner-background: red");
            count++;
        }
        if (count != 0) {
            textFieldError.setVisible(true);
            if(count == 1) {
                textFieldError.setText("Wrong value!");
            }
            else {
                textFieldError.setText("Wrong values!");
            }
            return;
        }
        try {
            newPerson.setAge(Integer.parseInt(textFieldAge.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldAge.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setNumber(Integer.parseInt(textFieldNumber.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldNumber.setStyle("-fx-control-inner-background: red");
            count++;
        }
        try {
            newPerson.setMoney(Integer.parseInt(textFieldMoney.getText()));
        } catch (IOException e) {
            e.printStackTrace();
            textFieldMoney.setStyle("-fx-control-inner-background: red");
            count++;
        }
        if (count != 0) {
            textFieldError.setVisible(true);
            if(count == 1) {
                textFieldError.setText("Wrong value!");
            }
            else {
                textFieldError.setText("Wrong values!");
            }
            return;
        }
        dataBase.objects.add(newPerson);
        Stage stage = (Stage) buttonDecline.getScene().getWindow();
        objectsTableView.refresh();
        stage.close();
    }

    /**
     * for getting database from main window
     * @param dataBase database from main window
     */
    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    /**
     * for getting table from main window
     * @param objectsTableView table from main window
     */
    public void setTable(TableView<Person> objectsTableView) {
        this.objectsTableView = objectsTableView;
    }

    /**
     * hotkeys for window
     * @param event input key
     */

    public void onKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ESCAPE)
            onButtonDeclineClick(new ActionEvent());
        if(event.getCode() == KeyCode.ENTER)
            onButtonSubmitClick(new ActionEvent());
    }
}
