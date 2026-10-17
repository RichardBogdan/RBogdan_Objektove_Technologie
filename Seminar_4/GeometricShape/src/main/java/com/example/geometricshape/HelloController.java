package com.example.geometricshape;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.awt.*;

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
    @FXML
    public void zmenFarbuKruhu() {
        for (Node my : root.getChildren()) {
            if (my instanceof MyCircle) {
                ((MyCircle) my).zmenaFarby(Color.BLUE);
            }
        }
    }

    @FXML
    public void posunDole(){
            for (int i = 0; i < root.getChildren().size(); i++) {
                Node my = root.getChildren().get(i);
                if (my instanceof GeometricShape) ((GeometricShape)my).posunDole();
            }

    }

}
