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
    protected void regLok() {
        Window owner = registrerLokaleKnapp.getScene().getWindow();
        if (lokNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn navn");
            return;
        }
        if (lokType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn type lokale");
            return;
        }
        if (lokAntallPlasser.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn antall plasser");
            return;
        }
        try {
            // String test=lokNavn.getText();
            Lokale test = new Lokale(lokNavn.getText(), lokType.getText(), Integer.parseInt(lokAntallPlasser.getText()));
            Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, owner, "Vellykket", "Lokalet er registrert");

        } catch (Exception e) {

        }
    }




}

