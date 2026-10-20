package com.example.weatherobject;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    public Pane root;

    @FXML
    public void onClickCloud() {
        root.getChildren().add(new Cloud());
    }

    @FXML
    public void onClickRaindrop() {
        root.getChildren().add(new Raindrop());
    }

    @FXML
    public void onClickSnowflake() {
        root.getChildren().add(new Snowflake());
    }

    @FXML
    public void zastavDazd() {
        for (Node n : root.getChildren()) {
            if (n instanceof Raindrop) {
                ((Raindrop) n).zastav();
            }
        }
    }

    @FXML
    public void zmenFarbuOblakov() {
        for (Node n : root.getChildren()) {
            if (n instanceof Cloud) {
                ((Cloud) n).zmenaFarby(Color.BLUE);
            }
        }
    }

    @FXML
    public void posunDolava() {
        for (Node n : root.getChildren()) {
            if (n instanceof WeatherObject) {
                ((WeatherObject) n).posunDolava();
            }
        }
    }
}