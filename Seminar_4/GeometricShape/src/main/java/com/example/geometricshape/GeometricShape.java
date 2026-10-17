package com.example.geometricshape;

import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class GeometricShape extends Canvas {
    protected Color farba;
    protected GraphicsContext gc;
    protected Timeline t1,t2;
    protected boolean pohyb = false;
    protected int poziciaXr;
    protected int poziciaYr;

    protected GeometricShape(){
        super(500,500);
        setLayoutY(80);
        gc = getGraphicsContext2D();

    }
    abstract void vykresliTvar();

    public void zmenaFarby(Color f) {
        farba = f;
    }
    public void posunDole(){
        gc.clearRect(0,0,500,500);
        poziciaYr += 30;
    }
}
