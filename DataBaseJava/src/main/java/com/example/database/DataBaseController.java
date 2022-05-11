package com.example.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class DataBaseController {

    @FXML
    private TableColumn<Person, Integer> ageColumn;

    @FXML
    private TableColumn<Person, Integer> moneyColumn;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, Integer> numberColumn;

    @FXML
    private TableView<Person> objectsTableView;

    private final DataBase data = new DataBase();
    private final String fileName = "dsa.txt";
    private final ObservableList<Person> list = FXCollections.observableList(data.objects);

    public void initialize(){
        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectsTableView.setItems(list);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<>("money"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        objectsTableView.setEditable(true);
    }

    @FXML
    void clickAddOjbectButton(ActionEvent event) {
        data.addObject(new Person());
        objectsTableView.refresh();
    }

    @FXML
    void clickReadFileButton(ActionEvent event) {
        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectsTableView.refresh();
    }

    @FXML
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);
    }

    public void clickDeleteButton(ActionEvent actionEvent) {
    }

    public void clickClearButton(ActionEvent actionEvent) {
        data.clear();
        objectsTableView.refresh();
    }
}
