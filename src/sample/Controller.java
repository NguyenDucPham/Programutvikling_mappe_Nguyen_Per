package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import static java.lang.String.valueOf;

public class Controller {

    @FXML
    private TextField lokNavn;

    @FXML
    private TextField lokType;

    @FXML
    private TextField lokAntallPlasser;

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
            Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, owner, "Vellykket", "Lokalet er registrert");
            Lokale sdfa = new Lokale(lokNavn.getText(),lokType.getText(), Integer.parseInt(lokAntallPlasser.getText()));

        } catch (Exception e) {

        }
    }




}

