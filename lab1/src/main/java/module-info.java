module com.example.time_class {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.time_class to javafx.fxml;
    exports com.example.time_class;
}