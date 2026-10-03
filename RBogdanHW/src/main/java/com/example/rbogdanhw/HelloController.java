package com.example.rbogdanhw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private Label BMI, Kategoria, chyba;
    @FXML private TextField tf1,tf2;
    private double vypocet_bmi;

    protected void vypocet(){              //vypocet BMI
        double a = Double.parseDouble(tf1.getText());
        double b = Double.parseDouble(tf2.getText())/100.0;
        vypocet_bmi = Math.round((a/(b*b))*10.0)/10.0;
    }
    protected boolean kontrola() {          //kontrola či je jeden z Textfieldov prázdny
        boolean ukoncit_vypocet = true;
        if (tf1.getText().isEmpty() || tf2.getText().isEmpty()) {
            chyba.setVisible(true);
            BMI.setText("BMI:");
            Kategoria.setText("Kategória:");
            ukoncit_vypocet = false;
            return ukoncit_vypocet;
        }
        else{chyba.setVisible(false);}
        return  ukoncit_vypocet;
    }
    protected void vypis(){                 //výpis BMI a kategórie
        BMI.setText("BMI: " + vypocet_bmi);
        if(vypocet_bmi < 18.5) Kategoria.setText("Kategória: Podváha");
        else if(18.5 <= vypocet_bmi && vypocet_bmi <= 24.9) Kategoria.setText("Kategória: Normálna");
        else if(25 <= vypocet_bmi && vypocet_bmi <= 29.9) Kategoria.setText("Kategória: Nadváha");
        else Kategoria.setText("Kategória: Obezita");
    }
    @FXML
    protected void klik(){
        if(!kontrola()){return;}
        vypocet();
        vypis();

    }

}
