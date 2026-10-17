package com.example.geometricshape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MyCircle extends GeometricShape {
    protected int smer = 1;

    protected MyCircle() {
        farba = Color.GREEN;

        t1 = new Timeline(
                new KeyFrame(Duration.millis(50), e -> pohybD())
        );

        t2 = new Timeline(
                new KeyFrame(Duration.millis(50), e -> pohybH())
        );

        t1.setCycleCount(Timeline.INDEFINITE);
        t2.setCycleCount(Timeline.INDEFINITE);

        vykresliTvar();
        pohybHD();
    }

    @Override
    void vykresliTvar() {
        poziciaXr = (int)(Math.random() * 480);
        poziciaYr = (int)(Math.random() * 480);

        gc.setFill(farba);
        gc.fillOval(poziciaXr, poziciaYr, 20, 20);
    }

    protected void pohybHD() {
        if (!pohyb && smer == 1) {
            t1.play();
        } else if (!pohyb && smer == 2) {
            t2.play();
        } else {
            t1.stop();
            t2.stop();
        }
    }

    protected void pohybD() {
        smer = 1;

        if (poziciaYr >= 470) {
            t1.stop();
            t2.play();
        } else {
            gc.clearRect(poziciaXr, poziciaYr, 20, 20);
            poziciaYr += 10;

            gc.setFill(farba);
            gc.fillOval(poziciaXr, poziciaYr, 20, 20);
        }
    }

    protected void pohybH() {
        smer = 2;

        if (poziciaYr <= 10) {
            t2.stop();
            t1.play();
        } else {
            gc.clearRect(poziciaXr, poziciaYr, 20, 20);
            poziciaYr -= 10;

            gc.setFill(farba);
            gc.fillOval(poziciaXr, poziciaYr, 20, 20);
        }
    }
}