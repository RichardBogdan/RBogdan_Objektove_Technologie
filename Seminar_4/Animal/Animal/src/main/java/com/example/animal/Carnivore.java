package com.example.animal;

import javafx.scene.paint.Color;

public class Carnivore extends Animal {

    public Carnivore() {
        super(6);
        vykresli();
    }
    @Override
    public void vykresli() {
        int x = 15, y = 15;
        gc.clearRect(0, 0, 50, 50);
        gc.setFill(Color.RED);
        gc.fillRect(x, y, 25, 25);
        gc.fillRect(x, y - 10, 5, 10);
        gc.fillRect(x + 20, y - 10, 5, 10);
        gc.setFill(Color.WHITE);
        gc.fillRect(x + 5, y + 5, 5, 5);
        gc.fillRect(x + 15, y + 5, 5, 5);
    }
    @Override
    public void pohyb() {
        posun(smer * rychlost);
    }
}