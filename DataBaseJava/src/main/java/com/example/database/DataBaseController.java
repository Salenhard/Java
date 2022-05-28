package com.example.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;


/**
 * controller for DataBase
 */
public class DataBaseController{

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
    private String fileName = "dsa.txt";
    private final ObservableList<Person> list = FXCollections.observableList(data.objects);

    /**
     * when program is started set all data from file and make table of it
     */
    public void initialize(){
        try {
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // связь с базой данных
        objectsTableView.setItems(list);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<>("money"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        objectsTableView.setEditable(true);
        // edit
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        numberColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        moneyColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        ageColumn.setOnEditCommit(
                event -> {
                    Person person = event.getRowValue();
                    try {
                        person.setAge(event.getNewValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    objectsTableView.refresh();
                }
        );

        moneyColumn.setOnEditCommit(
                event -> {
                    Person person = event.getRowValue();
                    try {
                        person.setMoney(event.getNewValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    objectsTableView.refresh();
                }
        );

        numberColumn.setOnEditCommit(
                event -> {
                    Person person = event.getRowValue();
                    try {
                        person.setNumber(event.getNewValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    objectsTableView.refresh();
                }
        );
        nameColumn.setOnEditCommit(
                event -> {
                    Person person = event.getRowValue();
                    person.setName(event.getNewValue());
                    objectsTableView.refresh();
                }
        );
        /* Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                data.saveFile(fileName);
            }
        },1000 ,14000); */
    }

    /**
     * adds new object to data
     * @param event input event
     */
    @FXML
    void clickAddOjbectButton(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(DataBaseApplication.class.getResource("newPerson-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("New person");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getUserData();
        stage.show();

        NewPersonController newPersonController = fxmlLoader.getController();
        newPersonController.setDataBase(data);
        newPersonController.setTable(objectsTableView);

    }

    /**
     * reads data from file
     * @param event input event
     */
    @FXML
    void clickReadFileButton(ActionEvent event) {
        try {
            data.objects.clear();
            data.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectsTableView.refresh();
    }

    /**
     * saves data in file
     * @param event input event
     */
    @FXML
    void clickSaveFileButton(ActionEvent event) {
        data.saveFile(fileName);
    }

    /**
     * deleting chosen object
     * @param actionEvent input event
     */
    public void clickDeleteButton(ActionEvent actionEvent) {
        data.objects.remove(list.indexOf(objectsTableView.getSelectionModel().getSelectedItem()));
        objectsTableView.refresh();
    }

    /**
     * clears all data
     * @param actionEvent input event
     */
    public void clickClearButton(ActionEvent actionEvent) {
        data.objects.clear();
        objectsTableView.refresh();
    }

    /**
     * opening dialog to choose file
     * @param actionEvent input event
     */
    public void onClickButtonOpenFile(ActionEvent actionEvent) {
        Stage stage = (Stage) objectsTableView.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource FIle");
        fileChooser.setInitialDirectory((new File(System.getProperty("user.home"))));
        fileName = String.valueOf(fileChooser.showOpenDialog(stage));
    }

    /**
     * hotkeys
     * @param event - input key
     * @throws IOException - if file is not opened
     */
    public void OnKeyPressed(KeyEvent event) throws IOException {
        if (event.isControlDown() && event.getCode() == KeyCode.R)
            clickReadFileButton(new ActionEvent());

        if (event.isControlDown() && event.getCode() == KeyCode.S)
            clickSaveFileButton(new ActionEvent());

        if (event.getCode() == KeyCode.DELETE)
            clickDeleteButton(new ActionEvent());

        if (event.isControlDown() && event.getCode() == KeyCode.A)
            clickAddOjbectButton(new ActionEvent());

        if (event.isControlDown() && event.getCode() == KeyCode.O)
            onClickButtonOpenFile(new ActionEvent());
    }
}
