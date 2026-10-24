package com.example.seminar_5_zadanie_2du;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML
    private ListView<NakupnyZoznam> list;
    @FXML
    private Label label;
    @FXML
    private TextField tf1, tf2;
    @FXML
    private Button remove;
    private ObservableList<NakupnyZoznam> items = FXCollections.observableArrayList();
    private int celkovy_pocet = 0;


    @FXML
    private void initialize() {
        list.setItems(items);
        list.setEditable(true);
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                remove.setDisable(newValue == null));
        list.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.DELETE) Odobrat();
        });
        tf1.setOnAction(e -> Pridat());
        tf2.setOnAction(e -> Pridat());
        remove.setDisable(true);
    }
    @FXML private void Pridat() {
        String item = tf1.getText().trim();
        String count = tf2.getText().trim();
        if(item.isEmpty()) return;
        if(count.isEmpty()) count = "1";
        try {
            if (Integer.parseInt(count) <= 0) throw new NumberFormatException();
            celkovy_pocet += Integer.parseInt(count);
        }
        catch (Exception e){
            tf2.clear();
            return;
        }
        items.add(new NakupnyZoznam(item,count));
        tf1.clear();
        tf2.clear();
        tf1.requestFocus();
        label.setText("Počet Kusov: " + celkovy_pocet);
    }

    @FXML private void Odobrat() {
        NakupnyZoznam toRemove = list.getSelectionModel().getSelectedItem();
        if(toRemove == null) return;
        celkovy_pocet -= Integer.parseInt(toRemove.getPocet().get());
        label.setText("Počet Kusov: " + celkovy_pocet);
        items.remove(toRemove);
    }
    @FXML private void Editovat() {
        int index = list.getSelectionModel().getSelectedIndex();
        if (index < 0) return;

        NakupnyZoznam toEdit = items.get(index);
        String item = tf1.getText().trim();
        String count = tf2.getText().trim();
        if (item.isEmpty()) return;
        if (count.isEmpty()) count = "1";

        try {
            int novy = Integer.parseInt(count);
            if (novy <= 0) throw new NumberFormatException();
            int stary = Integer.parseInt(toEdit.getPocet().get());
            celkovy_pocet += novy - stary;
        } catch (NumberFormatException e) {
            tf2.clear();
            return;
        }

        items.set(index, new NakupnyZoznam(item, count));
        label.setText("Počet Kusov: " + celkovy_pocet);
        tf1.clear();
        tf2.clear();
        tf1.requestFocus();
    }

}


