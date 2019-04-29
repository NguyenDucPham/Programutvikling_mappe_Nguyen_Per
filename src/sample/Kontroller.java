package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.scene.control.ComboBox;

import static java.lang.String.valueOf;

public class Kontroller {

    ObservableList<String> arrLagringList= FXCollections.observableArrayList("Valg1","valg2");
    ObservableList<String> lokLagringList= FXCollections.observableArrayList("Csv","Jobj");
    ObservableList<String> konLagringList= FXCollections.observableArrayList("Valg1","valg2");
    @FXML
    private TextField lokNavn;

    @FXML
    private TextField lokType;

    @FXML
    private TextField lokAntallPlasser;

    @FXML
    private Button registrerLokaleKnapp;

    @FXML
    private ComboBox arrLagringBox;
    @FXML
    private ComboBox lokLagringBox;
    @FXML
    private ComboBox konLagringBox;
    @FXML
    private void initialize(){
        arrLagringBox.setValue("valg1");
        arrLagringBox.setItems(arrLagringList);
        lokLagringBox.setValue("valg1");
        lokLagringBox.setItems(lokLagringList);
        konLagringBox.setValue("valg1");
        konLagringBox.setItems(konLagringList);
        
    }

    @FXML
    protected void lokReg(ActionEvent event) {
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
            Lokale lokale = new Lokale(lokNavn.getText(),lokType.getText(), Integer.parseInt(lokAntallPlasser.getText()));
            CsvLagring fil = new CsvLagring();
            fil.skriver(lokale,"lokale");
            JobjLagring fil2 = new JobjLagring();
            fil2.skriver(lokale,"lokale");
        } catch (Exception e) {

        }
    }
    /*
    *
    * Kontroller for arrangement
    *
    * */
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
    private Button arrRegistrerKnapp;

    @FXML
    private TextField arrAntallBilletter;


    @FXML
    protected void arrReg(ActionEvent event) {
        Window eier = registrerLokaleKnapp.getScene().getWindow();
        if (arrType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type");
            return;
        }
        if (arrNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type navn");
            return;
        }
        if (arrProgram.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn Program");
            return;
        }
        if (arrArtist.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn artist");
            return;
        }
        if (arrTidspunkt.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn tidspunkt");
            return;
        }
        if (arrPris.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn pris");
            return;
        }
        if (arrKontaktPerson.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn kontaktperson");
            return;
        }
        if (arrLokale.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn lokale");
            return;
        }
        ComboBox<Object> myComboBox = new ComboBox<Object>();
        try {
            Arrangement test = new Arrangement(arrKontaktPerson.getText(), arrType.getText(), arrNavn.getText(), arrArtist.getText(),
                    arrProgram.getText(), arrTidspunkt.getText(), arrPris.getText(), arrAntallBilletter.getText(), arrLokale.getText());
            Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, eier, "Vellykket", "Arrangement er registrert");

        } catch (Exception e) {

        }
    }



}

