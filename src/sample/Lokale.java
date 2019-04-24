package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.util.Arrays;

public class Lokale {

    private String LokalNavn;
    //skal være kino, konsertsal, foredragssal, teatersal
    private String LokalType;
    private int AntallPlasser;


    public Lokale(String lokalNavn, String lokalType, int antallPlasser) {
        LokalNavn = lokalNavn;
        LokalType = lokalType;
        AntallPlasser = antallPlasser;
    }


    @Override
    public String toString() {
        return LokalNavn + ";" + LokalType + ";" + AntallPlasser;
    }

    public String getLokalNavn() {
        return LokalNavn;
    }

    public void setLokalNavn(String lokalNavn) {
        LokalNavn = lokalNavn;
    }

    public String getLokalType() {
        return LokalType;
    }

    public void setLokalType(String lokalType) {
        LokalType = lokalType;
    }

    public int getAntallPlasser() {
        return AntallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        AntallPlasser = antallPlasser;
    }


}
