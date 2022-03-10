package com.example.time_class;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    public Label ConvertToSecondsLabel;
    @FXML
    public Label ConvertToMinutesLabel;
    @FXML
    public Label ConvertToHoursLabel;
    @FXML
    private Label TimeLabel;
    @FXML
    private TextField SetSecondsTextField;
    @FXML
    private TextField SetHoursTextField;
    @FXML
    private TextField SetMinutesTextField;
    @FXML
    private TextField AddSecondsTextField;
    @FXML
    private TextField AddMinutesTextField;
    @FXML
    private TextField AddHoursTextField;

    Time time = new Time();

    public void set_time() {                                                                        // устанавливает все значения времени
        TimeLabel.setText(time.toString());
        ConvertToHoursLabel.setText(Integer.toString(time.convert_to_hours()));
        ConvertToMinutesLabel.setText(Integer.toString(time.convert_to_minutes()));
        ConvertToSecondsLabel.setText(Integer.toString(time.convert_to_seconds()));
    }

    public void OnSetSecondsButtonClick(ActionEvent actionEvent) {                                      // Кнопка установить секунды
        try {
            time.setSeconds(Integer.parseInt(SetSecondsTextField.getText()));
        }
        catch (NullPointerException e) {
            e.getMessage();
        }
        set_time();
    }

    public void OnSetMinutesButtonClick(ActionEvent actionEvent) {                                      // Кнопка установить минуты
        try {
            time.setMinutes(Integer.parseInt(SetMinutesTextField.getText()));
        }
        catch (NullPointerException e) {
            e.getMessage();
        }
        set_time();
    }

    public void OnSetHoursButtonClick(ActionEvent actionEvent) {                                          // Кнопка установить часы
        try {
            time.setHours(Integer.parseInt(SetHoursTextField.getText()));
        }
        catch (NullPointerException e) {
            e.getMessage();
        }
        set_time();
    }

    public void OnAddSecondsButtonClick(ActionEvent actionEvent){                                       // Кнопка добавляет секунды
        try{
            time.addSeconds(Integer.parseInt(AddSecondsTextField.getText()));
        }
        catch (NullPointerException e){
            e.getMessage();
        }
        set_time();
    }

    public void OnAddMinutesButtonClick(ActionEvent actionEvent){                                       // Кнопка добавляет минуты
        try{
            time.addMinutes(Integer.parseInt(AddMinutesTextField.getText()));
        }
        catch (NullPointerException e){
            e.getMessage();
        }
        set_time();
    }

    public void OnAddHoursButtonClick(ActionEvent actionEvent){                                       // Кнопка добавляет часы
        try{
            time.addHours(Integer.parseInt(AddHoursTextField.getText()));
        }
        catch (NullPointerException e){
            e.getMessage();
        }
        set_time();
    }
}