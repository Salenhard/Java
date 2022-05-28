package com.example.database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
     * @throws IOException if stage is broken
     */
    @FXML
    void onButtonSubmitClick(ActionEvent event) throws IOException {
        Person newPerson = new Person(textFieldName.getText(), Integer.parseInt(textFieldAge.getText()), Integer.parseInt(textFieldNumber.getText()), Integer.parseInt(textFieldMoney.getText()));
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

    public void onKeyPressed(KeyEvent event) throws IOException {
        if(event.getCode() == KeyCode.ESCAPE)
            onButtonDeclineClick(new ActionEvent());
        if(event.getCode() == KeyCode.ENTER)
            onButtonSubmitClick(new ActionEvent());
    }
}
