package com.example.weatherobject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

abstract public class WeatherObject extends Canvas {
    protected static final int SIRKA = 500;
    protected static final int VYSKA = 500;
    protected static final int ZACIATOK_Y = 80;

    protected Color farba;
    protected GraphicsContext gc;
    protected Timeline t;

    protected WeatherObject(double sirka, double vyska) {
        super(sirka, vyska);
        gc = getGraphicsContext2D();
        t = new Timeline(new KeyFrame(Duration.millis(50), e -> pohyb()));
        t.setCycleCount(Timeline.INDEFINITE);
    }

    protected abstract void vykresliTvar();

    protected abstract void pohyb();

    public void spusti() {
        t.play();
    }

    public void zastav() {
        t.stop();
    }

    public void zmenaFarby(Color f) {
        farba = f;
        gc.clearRect(0, 0, getWidth(), getHeight());
        vykresliTvar();
    }

    public void posunDolava() {
        setLayoutX(getLayoutX() - 20);
    }

    protected void zanik() {
        t.stop();
        Pane rodic = (Pane) getParent();
        if (rodic != null) {
            rodic.getChildren().remove(this);
        }
    }
}