package com.example.auto;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {
    private GraphicsContext gc;
    private Timeline t,t2;
    private boolean ide = false;                //klik na auto
    private boolean doprava = true;             //smer auta po kliknuti
    private int polohax = 70;
    private int polohay = 240;

    protected Auto(){                       //vykreslenie auta s pozadim, eventmi na automat, manual
        super(500,280);
        this.gc = getGraphicsContext2D();
        setOnMousePressed(e -> {
            if (e.getSceneX() >= polohax && e.getSceneX() <= polohax+50
            && e.getSceneY() >= polohay &&e.getSceneY() <= polohay+30){spusti();}
        });
        setOnKeyPressed(event -> {
            if (!ide) {
                KeyCode k = event.getCode();
                if (k == KeyCode.UP) pohyb_H();
                if (k == KeyCode.DOWN) pohyb_D();
                if (k == KeyCode.LEFT) pohyb_L();
                if (k == KeyCode.RIGHT) pohyb_P();
            }
        });
        setFocusTraversable(true);
        requestFocus();

        vykresli(polohax,polohay);
        t = new Timeline(new KeyFrame(Duration.millis(50),e -> pohyb_P()));
        t2 = new Timeline(new KeyFrame(Duration.millis(50),e -> pohyb_L()));
        t.setCycleCount(Timeline.INDEFINITE);
        t2.setCycleCount(Timeline.INDEFINITE);

    }
    protected void vykresli(int polohax, int polohay){
        gc.setFill(Color.WHITE);
        gc.fillRect(50,50,500,280);
        gc.setFill(Color.BLACK);
        gc.strokeRect(50,50,450,230);
        gc.setFill(Color.RED);
        gc.fillRect(this.polohax,this.polohay,50,30);      //20,240
    }
    protected void spusti(){
        if(!ide){
            if (doprava) t.play();
            else t2.play();
            ide = true;
        }
        else {
            t.stop();
            t2.stop();
            ide = false;
        }
    }
    protected void pohyb_P(){
        if(polohax == 450 && !ide)return;
        else if (polohax != 450) polohax += 10;
        vykresli(polohax,polohay);
        if (polohax >= 450 && ide){
            t.stop();
            t2.play();
            doprava = false;
        }
    }

    protected void pohyb_L() {
        if (polohax == 50 && !ide) return;
        else if(polohax != 50) polohax -= 10;
        vykresli(polohax, polohay);
        if (polohax <= 50 && ide) {
            t2.stop();
            t.play();
            doprava = true;
        }
    }
    protected void pohyb_H(){
        if (polohay == 50)return;
        else polohay -= 10;
        vykresli(polohax,polohay);


    }
    protected void pohyb_D(){
        if (polohay == 250)return;
        else polohay += 10;
        vykresli(polohax,polohay);
    }
}
