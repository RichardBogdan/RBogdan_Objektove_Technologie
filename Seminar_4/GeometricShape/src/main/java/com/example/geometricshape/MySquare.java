

package com.example.geometricshape;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MySquare extends GeometricShape {

    protected int smer = 1;
    protected double uhol = 0;
    protected double rychlostUhlu = 0.1;

    protected int stredX;
    protected int stredY;
    protected int polomer = 150;

    protected MySquare() {
        t1 = new Timeline(new KeyFrame(Duration.millis(50), e -> pohybuj()));
        t2 = new Timeline(new KeyFrame(Duration.millis(50), e -> pohybuj()));
        t1.setCycleCount(Timeline.INDEFINITE);
        t2.setCycleCount(Timeline.INDEFINITE);

        vykresliTvar();
        dokruhuPL();
    }

    @Override
    void vykresliTvar() {
        stredX = (int)(Math.random()*480);
        stredY = (int)(Math.random()*480);
        if(stredX + polomer > 479)vykresliTvar();
        else{
        poziciaXr = stredX + polomer;
        poziciaYr = stredY;

        gc.setFill(Color.DARKVIOLET);
        gc.fillRect(poziciaXr, poziciaYr, 20, 20);
        }
    }

    protected void dokruhuPL() {
        if (!pohyb && smer == 1) {
            t1.play();
        } else if (!pohyb && smer == 2) {
            t2.play();
        } else {
            t1.stop();
            t2.stop();
        }
    }

    protected void dokruhuP() {
        pohybuj();
    }

    protected void dokruhuL() {
        pohybuj();
    }

    protected void pohybuj() {

        gc.clearRect(
                poziciaXr - 2,
                poziciaYr - 2,
                24,
                24
        );
        double novyUhol = uhol + rychlostUhlu;
        int noveX = stredX
                + (int) (polomer * Math.cos(novyUhol));
        int noveY = stredY
                + (int) (polomer * Math.sin(novyUhol));
        if (noveX <= 0 || noveX + 20 >= 500
                || noveY <= 0 || noveY + 20 >= 500) {
            rychlostUhlu = -rychlostUhlu;
            if (rychlostUhlu > 0) {
                smer = 1;
            } else {
                smer = 2;
            }

        } else {
            uhol = novyUhol;
        }
        poziciaXr = stredX
                + (int) (polomer * Math.cos(uhol));
        poziciaYr = stredY
                + (int) (polomer * Math.sin(uhol));
        gc.setFill(Color.DARKVIOLET);
        gc.fillRect(poziciaXr, poziciaYr, 20, 20);
    }
}

