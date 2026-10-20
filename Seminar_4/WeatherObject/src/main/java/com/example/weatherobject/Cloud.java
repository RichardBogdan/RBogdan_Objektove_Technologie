package com.example.weatherobject;

import javafx.scene.paint.Color;

public class Cloud extends WeatherObject {
    private int smer = 1;

    public Cloud() {
        super(100, 50);
        farba = Color.GRAY;
        setLayoutX(Math.random() * (SIRKA - 100));
        setLayoutY(ZACIATOK_Y);
        vykresliTvar();
        spusti();
    }

    @Override
    protected void vykresliTvar() {
        gc.setFill(farba);
        gc.fillOval(5, 20, 40, 28);
        gc.fillOval(25, 5, 50, 40);
        gc.fillOval(55, 18, 40, 30);
        gc.fillRect(25, 28, 50, 20);
    }

    @Override
    protected void pohyb() {
        double x = getLayoutX();

        if (x <= 0) {
            smer = 1;
        } else if (x >= SIRKA - 100) {
            smer = -1;
        }

        setLayoutX(x + smer);
    }
}