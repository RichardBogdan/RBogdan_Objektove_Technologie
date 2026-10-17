package com.example.geometricshape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MyRectangle extends GeometricShape{
    protected int smer = 1;

    protected MyRectangle(){
        t1 = new Timeline(new KeyFrame(Duration.millis(50),e -> pohybP()));
        t2 = new Timeline(new KeyFrame(Duration.millis(50), e -> pohybL()));
        t1.setCycleCount(Timeline.INDEFINITE);
        t2.setCycleCount(Timeline.INDEFINITE);
        vykresliTvar();
        pohybLP();
    }

    @Override
    void vykresliTvar() {
        poziciaXr = (int)(Math.random()*480);
        poziciaYr = (int)(Math.random()*470);
        gc.setFill(Color.ORANGE);
        gc.fillRect(poziciaXr, poziciaYr,20,30);

    }
    protected void pohybLP(){
        if (!pohyb && smer == 1){
            t1.play();
        }
        else if(!pohyb && smer == 2){
            t2.play();
        }
        else {t1.stop();t2.stop();}
    }
    protected void pohybP(){
        smer = 1;

        if(poziciaXr >= 470){t1.stop();t2.play();}
        else{
            gc.clearRect(poziciaXr, poziciaYr,20,30);
            poziciaXr += 10;
            gc.setFill(Color.ORANGE);
            gc.fillRect(poziciaXr, poziciaYr,20,30);

        }
    }
    protected void pohybL(){
        smer = 2;

        if(poziciaXr <= 10){t2.stop();t1.play();}
        else{
            gc.clearRect(poziciaXr, poziciaYr,20,30);
            poziciaXr -= 10;
            gc.setFill(Color.ORANGE);
            gc.fillRect(poziciaXr, poziciaYr,20,30);

        }
    }

}
