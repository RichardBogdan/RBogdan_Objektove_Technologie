package com.example.animal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;

public abstract class Animal extends Canvas {
    protected static final int LEFT = 20;
    protected static final int TOP = 60;
    protected static final int SIDE = 400;
    protected GraphicsContext gc;
    protected Timeline timeline;
    protected double d;
    protected int smer = 1;
    protected double rychlost;

    protected Animal(double rychlost) {
        super(50, 50);
        this.rychlost = rychlost;
        gc = getGraphicsContext2D();
        d = Math.random() * 4 * SIDE;
        timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> pohyb()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        umiestni();
    }

    public abstract void vykresli();
    public abstract void pohyb();

    protected void posun(double krok) {
        double obvod = 4.0 * SIDE;
        d = ((d + krok) % obvod + obvod) % obvod;
        umiestni();
    }
    protected void umiestni() {
        double x, y;
        if (d < SIDE) {
            x = LEFT + d;
            y = TOP;
        } else if (d < 2 * SIDE) {
            x = LEFT + SIDE;
            y = TOP + (d - SIDE);
        } else if (d < 3 * SIDE) {
            x = LEFT + SIDE - (d - 2 * SIDE);
            y = TOP + SIDE;
        } else {
            x = LEFT;
            y = TOP + SIDE - (d - 3 * SIDE);
        }
        setLayoutX(x);
        setLayoutY(y);
    }
    public void spusti() {
        timeline.play();
    }
    public void zastav() {
        timeline.pause();
    }
    public void zmenSmer() {
        smer = -smer;
    }
}