module org.example.chatappllicationclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.chatappllicationclient to javafx.fxml;
    exports org.example.chatappllicationclient;
}