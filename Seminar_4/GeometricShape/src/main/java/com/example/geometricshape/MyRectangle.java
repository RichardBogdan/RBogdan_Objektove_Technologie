package com.example.geometricshape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MyRectangle extends GeometricShape{
    protected MyRectangle(){
        vykresliTvar();
        t1 = new Timeline(new KeyFrame(Duration.millis(10)));
        t1.setCycleCount(Timeline.INDEFINITE);
    }

    @Override
    void vykresliTvar() {
        poziciaXr = (int)(Math.random()*480);
        poziciaYr = (int)(Math.random()*470);
        gc.setFill(Color.ORANGE);
        gc.fillRect(poziciaXr, poziciaYr,20,30);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(poziciaXr, poziciaYr,20,30);
    }
    protected void pohybLP(){
        if (pohyb){
            t1.play();
        }
        else t1.stop();
    }
    protected void pohybP(){
        gc.clearRect(poziciaXr, poziciaYr,20,30);
        poziciaXr += 10;
        gc.setFill(Color.ORANGE);
        gc.fillRect(poziciaXr, poziciaYr,20,30);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(poziciaXr, poziciaYr,20,30);
    }


}
