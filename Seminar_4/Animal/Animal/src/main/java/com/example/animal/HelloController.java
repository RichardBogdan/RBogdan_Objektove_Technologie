package com.example.animal;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML public Pane root;
    private final List<Animal> zvierata = new ArrayList<>();
    private boolean zastavene = false;
    private void pridaj(Animal a) {
        zvierata.add(a);
        root.getChildren().add(a);
        if (!zastavene) {
            a.spusti();
        }
    }
    @FXML
    public void onPridajCarnivore() {
        pridaj(new Carnivore());
    }
    @FXML
    public void onPridajHerbivore() {
        pridaj(new Herbivore());
    }
    @FXML
    public void onZmenSmer() {
        for (Animal a : zvierata) {
            if (a instanceof Carnivore) {
                a.zmenSmer();
            }
        }
    }
    @FXML
    public void onStop() {
        zastavene = !zastavene;
        for (Animal a : zvierata) {
            if (zastavene) {
                a.zastav();
            } else {
                a.spusti();
            }
        }
    }
}