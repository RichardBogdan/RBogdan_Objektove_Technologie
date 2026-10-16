package com.example.geometricshape;

import javafx.scene.paint.Color;

public class MySquare extends GeometricShape{
    protected MySquare(){
        vykresliTvar();
    }

    @Override
    void vykresliTvar() {
        poziciaXr = (int)(Math.random()*480);
        poziciaYr = (int)(Math.random()*480);
        gc.setFill(Color.GREEN);
        gc.fillRect(poziciaXr, poziciaYr,20,20);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(poziciaXr, poziciaYr,20,20);
    }
}
