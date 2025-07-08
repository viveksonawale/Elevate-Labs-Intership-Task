module org.codebyvivek.chatapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.codebyvivek.chatapplication to javafx.fxml;
    exports org.codebyvivek.chatapplication;
}