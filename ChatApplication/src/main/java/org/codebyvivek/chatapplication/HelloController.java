package org.codebyvivek.chatapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label label;

    @FXML
    private void handleClick() {
        label.setText("You clicked the button!");
    }
}
