package com.example.weatherobject;


import javafx.scene.paint.Color;

public class Raindrop extends WeatherObject {

    public Raindrop() {
        super(10, 20);
        farba = Color.DODGERBLUE;
        setLayoutX(Math.random() * (SIRKA - 10));
        setLayoutY(ZACIATOK_Y + Math.random() * (VYSKA - 20));
        vykresliTvar();
        spusti();
    }

    @Override
    protected void vykresliTvar() {
        gc.setFill(farba);
        gc.fillPolygon(new double[]{5, 10, 0}, new double[]{0, 12, 12}, 3);
        gc.fillOval(0, 8, 10, 12);
    }

    @Override
    protected void pohyb() {
        setLayoutY(getLayoutY() + 10);

        if (getLayoutY() > ZACIATOK_Y + VYSKA) {
            zanik();
        }
    }
}