package com.example.seminar_5_zadanie_2du;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NakupnyZoznam {
    protected StringProperty produkt = new SimpleStringProperty();
    protected StringProperty pocet = new SimpleStringProperty();


    protected NakupnyZoznam(String produkt, String pocet){
        setProdukt(produkt);
        setPocet(pocet);
    }
    public void setProdukt(String produkt){
        this.produkt.set(produkt);
    }
    public void setPocet(String pocet){
        this.pocet.set(pocet.trim());
    }
    public StringProperty getProdukt(){
        return produkt;
    }
    public StringProperty getPocet(){
        return pocet;
    }
    @Override
    public String toString() {
        return produkt.get() + " " + pocet.get();
    }

}
