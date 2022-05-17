module com.example.chat_bot {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens com.example.chat_bot to javafx.fxml;
    exports com.example.chat_bot;
}