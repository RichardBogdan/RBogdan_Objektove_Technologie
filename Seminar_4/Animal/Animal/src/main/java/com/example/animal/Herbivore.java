package com.example.animal;

import javafx.scene.paint.Color;

public class Herbivore extends Animal {

    public Herbivore() {
        super(3);
        vykresli();
    }
    @Override
    public void vykresli() {
        int x = 15, y = 15;
        gc.clearRect(0, 0, 50, 50);
        gc.setFill(Color.DARKGREEN);
        gc.fillRect(x, y, 25, 25);
        gc.fillRect(x - 10, y, 10, 5);
        gc.fillRect(x + 25, y, 10, 5);
        gc.fillRect(x - 10, y, 5, 10);
        gc.fillRect(x + 30, y, 5, 10);
        gc.setFill(Color.WHITE);
        gc.fillRect(x + 5, y + 10, 5, 5);
        gc.fillRect(x + 15, y + 10, 5, 5);
    }
    @Override
    public void pohyb() {
        posun(rychlost);
    }
}