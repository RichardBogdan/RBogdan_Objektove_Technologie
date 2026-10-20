package com.example.weatherobject;

import javafx.scene.paint.Color;

public class Snowflake extends WeatherObject {
    private double uhol = 0;

    public Snowflake() {
        super(16, 16);
        farba = Color.LIGHTSKYBLUE;
        setLayoutX(Math.random() * (SIRKA - 16));
        setLayoutY(ZACIATOK_Y + Math.random() * (VYSKA - 16));
        vykresliTvar();
        spusti();
    }

    @Override
    protected void vykresliTvar() {
        gc.setStroke(farba);
        gc.setLineWidth(1.5);

        for (int i = 0; i < 3; i++) {
            double a = i * Math.PI / 3;
            double dx = 7 * Math.cos(a);
            double dy = 7 * Math.sin(a);
            gc.strokeLine(8 - dx, 8 - dy, 8 + dx, 8 + dy);
        }
    }

    @Override
    protected void pohyb() {
        uhol += 0.2;
        setLayoutX(getLayoutX() + Math.sin(uhol) * 3);
        setLayoutY(getLayoutY() + 3);

        if (getLayoutY() > ZACIATOK_Y + VYSKA) {
            zanik();
        }
    }
}