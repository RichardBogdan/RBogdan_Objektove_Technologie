package com.example.geometricshape;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    public Pane root;
    public GeometricShape sq;
    public GeometricShape ci;
    public GeometricShape re;

    @FXML
    public void onClickSquare(){
        sq = new MySquare();
        root.getChildren().add(sq);
    }

    @FXML
    public void onClickCircle(){
        ci = new MyCircle();
        root.getChildren().add(ci);
    }

    @FXML
    public void onClickRectangle(){
        re = new MyRectangle();
        root.getChildren().add(re);
    }
}
