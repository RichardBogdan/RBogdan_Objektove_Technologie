package com.example.seminar_3_zadanie_2_du;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;


public class Robot extends Canvas{
    private GraphicsContext gc;
    private Timeline t1,t2;
    private boolean pohyb = false;
    private int smer = 1;
    private int polohax = 10;
    private int polohay = 170;

    protected Robot(){
        super(500,400);
        setLayoutX(50);
        setLayoutY(50);
        gc = getGraphicsContext2D();
        vykresli(smer);
        setOnMouseClicked(e -> {
            if(e.getSceneX() >= polohax+50 && e.getSceneX() <= polohax+30+50
            && e.getSceneY() >= polohay+50 && e.getSceneY() <= polohay+50+50) start();
        });
        setOnKeyPressed(event -> {
            KeyCode k = event.getCode();
            if(!pohyb) {
                if (k == KeyCode.W) pohyb_h();
                else if (k == KeyCode.A) pohyb_l();
                else if (k == KeyCode.S) pohyb_d();
                else if (k == KeyCode.D) pohyb_p();
            }
        });
        setFocusTraversable(true);
        requestFocus();
        t1 = new Timeline(new KeyFrame(Duration.millis(100) ,e -> pohyb_p()));
        t1.setCycleCount(Timeline.INDEFINITE);
        t2 = new Timeline(new KeyFrame(Duration.millis(100) ,e -> pohyb_l()));
        t2.setCycleCount(Timeline.INDEFINITE);
    }

    protected void vykresli(int smer){
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,500,400);
        gc.setFill(Color.BLACK);
        gc.strokeRect(0,0,500,400);

        switch (smer){
            case 1:vykresli_robotaP(polohax,polohay);break;
            case 2:vykresli_robotaL(polohax,polohay);break;
            case 3:vykresli_robotaH(polohax,polohay);break;
            case 4:vykresli_robotaD(polohax,polohay);break;
        }
    }

    protected void start(){
        if(!pohyb){
            t1.play();
            pohyb = true;
        }
        else{
            t1.stop();
            t2.stop();
            pohyb = false;
        }
    }

    protected void vykresli_robotaP(int polohax, int polohay){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(polohax,polohay, 30, 50);
        gc.setFill(Color.RED);
        gc.fillRect(polohax + 20,polohay + 10, 5, 5);
        gc.strokeLine(polohax + 20, polohay + 20, polohax + 30, polohay + 20);
    }
    protected void vykresli_robotaL(int polohax, int polohay){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(polohax,polohay, 30, 50);
        gc.setFill(Color.RED);
        gc.fillRect(polohax,polohay + 10, 5, 5);
        gc.strokeLine(polohax, polohay + 20, polohax + 10, polohay + 20);
    }
    protected void vykresli_robotaH(int polohax, int polohay){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(polohax,polohay, 30, 50);
    }
    protected void vykresli_robotaD(int polohax,int polohay){
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(polohax,polohay, 30, 50);
        gc.setFill(Color.RED);
        gc.fillRect(polohax + 20,polohay + 10, 5, 5);
        gc.fillRect(polohax + 5,polohay + 10, 5, 5);
        gc.strokeLine(polohax+10, polohay + 20, polohax + 20, polohay + 20);
    }
    protected void pohyb_p(){
        smer = 1;
        if(polohax == 470 && !pohyb)return;  //opr
        else if(polohax != 470)polohax += 10;
        vykresli(smer);
        if(polohax >= 470 && pohyb){
            t1.stop();
            t2.play();
        }
    }
    protected void pohyb_l(){
        smer = 2;
        if(polohax == 0 && !pohyb)return;  //opr
        else if(polohax != 0)polohax -= 10;
        vykresli(smer);
        if(polohax <= 0 && pohyb){
            t2.stop();
            t1.play();
        }
    }
    protected void pohyb_h(){
        smer = 3;
        if(polohay == 0){return;}  //opr
        else polohay -= 10;
        vykresli(smer);
    }
    protected void pohyb_d(){
        smer = 4;
        if (polohay == 350) {; return;} //opr
        else polohay += 10;
        vykresli(smer);
    }

}
