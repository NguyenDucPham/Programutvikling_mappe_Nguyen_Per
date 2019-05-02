package sample;

import javafx.beans.property.SimpleStringProperty;

public class Tabell {
    private SimpleStringProperty navn;
    private SimpleStringProperty lokaleType;
    private SimpleStringProperty pris;
    private SimpleStringProperty tidspunkt;


    public Tabell(String navn, String lokaleType, String pris, String tidspunkt){
        this.navn = new SimpleStringProperty(navn);
        this.lokaleType = new SimpleStringProperty(lokaleType);
        this.pris = new SimpleStringProperty(pris);
        this.tidspunkt = new SimpleStringProperty(tidspunkt);

    }

    public void setNavn(String navn){
        this.navn.set(navn);
    }
    public SimpleStringProperty navnProperty() {
        return navn;
    }


    public SimpleStringProperty lokaleTypeProperty() {
        return lokaleType;
    }


    public SimpleStringProperty prisProperty() {
        return pris;
    }


    public SimpleStringProperty tidspunktProperty() {
        return tidspunkt;
    }


    @Override
    public String toString() {
        return navn + ";" + lokaleType + ";" + pris + ";" + tidspunkt;
    }
}
