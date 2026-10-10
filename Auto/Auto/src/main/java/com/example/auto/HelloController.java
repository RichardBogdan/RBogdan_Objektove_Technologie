package com.example.auto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController{
    @FXML private Pane root;
    private Auto a;
    @FXML protected void initialize(){
        a = new Auto();
        root.getChildren().add(a);
    }


}
