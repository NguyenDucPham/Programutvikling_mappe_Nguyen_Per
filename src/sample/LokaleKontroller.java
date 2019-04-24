package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import static java.lang.String.valueOf;

public class LokaleKontroller {

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
        Window eier = registrerLokaleKnapp.getScene().getWindow();
        if (lokNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn navn");
            return;
        }
        if (lokType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type lokale");
            return;
        }
        if (lokAntallPlasser.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn antall plasser");
            return;
        }
        try {
            Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, eier, "Vellykket", "Lokalet er registrert");
            Lokale sdfa = new Lokale(lokNavn.getText(),lokType.getText(), Integer.parseInt(lokAntallPlasser.getText()));
            CsvLagring fil = new CsvLagring();
            fil.skriver(sdfa,"lokale");
        } catch (Exception e) {

        }
    }




}

