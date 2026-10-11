package com.example.seminar_3_zadanie_2_du;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    private Robot r;

    @FXML protected void initialize(){
        r = new Robot();
        root.getChildren().add(r);
   }
}
