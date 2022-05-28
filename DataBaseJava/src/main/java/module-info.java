/**
 * DataBase for education
 * @author Vladislav Gurbatov
 */
module com.example.database {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.database to javafx.fxml;
    exports com.example.database;
}