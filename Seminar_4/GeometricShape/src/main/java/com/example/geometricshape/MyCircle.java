package com.example.geometricshape;

import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape{
    protected MyCircle(){
        vykresliTvar();
    }

    @Override
    void vykresliTvar() {
        poziciaXr = (int)(Math.random()*480);
        poziciaYr = (int)(Math.random()*480);
        gc.setFill(Color.YELLOWGREEN);
        gc.fillOval(poziciaXr, poziciaYr,20,20);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(poziciaXr, poziciaYr,20,20);
    }
}
