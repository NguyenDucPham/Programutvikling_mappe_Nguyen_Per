package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import static java.lang.String.valueOf;

public class ArrangementKontroller {

    @FXML
    private TextField arrNavn;

    @FXML
    private TextField arrType;

    @FXML
    private TextField arrProgram;

    @FXML
    private TextField arrArtist;

    @FXML
    private TextField arrTidspunkt;

    @FXML
    private TextField arrPris;

    @FXML
    private TextField arrKontaktPerson;

    @FXML
    private TextField arrLokale;

    @FXML
    private Button registrerLokaleKnapp;


    @FXML
    protected void arrReg() {
        Window eier = registrerLokaleKnapp.getScene().getWindow();
        if (arrType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type");
            return;
        }
        if (arrNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type navn");
            return;
        }
        if (arrArtist.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn artist");
            return;
        }
        try {

           // Lokale test = new Lokale(lokNavn.getText(), lokType.getText(), Integer.parseInt(lokAntallPlasser.getText()));
           // Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, owner, "Vellykket", "Lokalet er registrert");

        } catch (Exception e) {

        }
    }




}

