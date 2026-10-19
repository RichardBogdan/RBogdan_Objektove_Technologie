package com.example.elevator_2;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.function.IntConsumer;

public class Elevator extends Canvas {
    private final GraphicsContext gc;
    private final Timeline t1;
    private final PauseTransition pauza = new PauseTransition(Duration.seconds(2));
    private final IntConsumer onFloorChange;

    private int py = 500;
    private int poschodie = 0;
    private int kam_ideme = 500;
    private int cakajuci = -1;
    private boolean pohybuje = false;
    private boolean caka = false;

    public Elevator(int w, int h, IntConsumer onFloorChange) {
        super(w, h);
        this.onFloorChange = onFloorChange;

        setLayoutX(50);
        setLayoutY(50);
        gc = getGraphicsContext2D();

        t1 = new Timeline(new KeyFrame(Duration.millis(20), e -> pohyb()));
        t1.setCycleCount(Timeline.INDEFINITE);

        pauza.setOnFinished(e -> {
            caka = false;
            int f = cakajuci;
            cakajuci = -1;
            if (f != -1 && f != poschodie) {
                start(f);
            }
        });

        setFocusTraversable(true);
        setOnMouseClicked(e -> requestFocus());
        setOnKeyPressed(e -> {
            String s = e.getText();
            if (s.length() == 1 && Character.isDigit(s.charAt(0))) {
                kontrola(Integer.parseInt(s));
            }
        });

        vykresli();
        onFloorChange.accept(0);
    }

    private void vykresli() {
        gc.clearRect(0, 0, getWidth(), getHeight());


        gc.setStroke(Color.GRAY);
        gc.setFill(Color.BLACK);
        for (int f = 0; f <= 8; f++) {
            double y = 540 - f * 50;
            gc.strokeLine(40, y, 120, y);
            gc.fillText(String.valueOf(f), 20, y - 5);
        }

        gc.setFill(Color.RED);
        gc.fillRect(50, py, 50, 40);
    }

    private void kontrola(int a) {
        if (a < 0 || a > 8) return;

        if (pohybuje || caka) {
            cakajuci = a;
        } else if (a != poschodie) {
            start(a);
        }
    }

    private void start(int a) {
        kam_ideme = 500 - a * 50;
        pohybuje = true;
        t1.play();
    }

    private void pohyb() {
        if (py > kam_ideme) {
            poschodieH();
        } else if (py < kam_ideme) {
            poschodieD();
        }

        int nove = (int) Math.round((500 - py) / 50.0);
        if (nove != poschodie) {
            poschodie = nove;
            onFloorChange.accept(poschodie);
        }

        if (py == kam_ideme) {
            t1.stop();
            pohybuje = false;
            if (cakajuci != -1) {
                caka = true;
                pauza.playFromStart();
            }
        }
    }

    private void poschodieH() {
        py -= 2;
        vykresli();
    }

    private void poschodieD() {
        py += 2;
        vykresli();
    }
}