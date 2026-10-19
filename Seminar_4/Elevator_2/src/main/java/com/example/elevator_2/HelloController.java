package com.example.elevator_2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane root;
    @FXML
    private Label label;
    private Elevator el;

    public void initialize() {
        el = new Elevator(300, 600, f -> label.setText("Poschodie: " + f));
        root.getChildren().add(el);
        Platform.runLater(() -> el.requestFocus());
    }
}