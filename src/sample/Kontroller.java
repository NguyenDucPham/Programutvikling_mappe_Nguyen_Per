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
import jdk.nashorn.internal.runtime.arrays.ArrayIndex;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Kontroller {

    ObservableList<String> arrLagringList= FXCollections.observableArrayList("Csv","Jobj");
    ObservableList<String> lokLagringList= FXCollections.observableArrayList("Csv","Jobj");
    ObservableList<String> konLagringList= FXCollections.observableArrayList("Csv","Jobj");
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
    private ComboBox lokaleComboBox;
    @FXML
    private void initialize(){
        arrLagringBox.setValue("Csv");
        arrLagringBox.setItems(arrLagringList);
        lokLagringBox.setValue("Csv");
        lokLagringBox.setItems(lokLagringList);
        konLagringBox.setValue("Csv");
        konLagringBox.setItems(konLagringList);
        /*CsvLasting innlasting = new CsvLasting();
        String lokaleString = innlasting.leser("lokale");
        String[] lokaleArray = Splittere.linjeSplitter(lokaleString);
        String[][] lokaleDArray = Splittere.objectSplitter(lokaleArray);
        ObservableList<String> lokaleInnlastingList = FXCollections.observableArrayList();
        try {
            ArrayList<String> lokaleListe=new ArrayList<>();
            for (int i = 0; i < lokaleArray.length; i++) {
                lokaleListe.add(lokaleDArray[i][0]);
            }
            lokaleInnlastingList = FXCollections.observableArrayList(lokaleListe);
            lokaleComboBox.setValue(lokaleDArray[0][0]);
            lokaleComboBox.setItems(lokaleInnlastingList);
        }catch(Exception e){}*/
        JobjLasting jobjLasting = new JobjLasting();
        String lokaleString = null;
        try {
            lokaleString = jobjLasting.leser("lokale");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lokaleArray = Splittere.linjeSplitter(lokaleString);
        String[][] lokaleDArray = Splittere.objectSplitter(lokaleArray);
        ObservableList<String> lokaleInnlastingList = FXCollections.observableArrayList();
        try {
            ArrayList<String> lokaleListe=new ArrayList<>();
            for (int i = 0; i < lokaleArray.length; i++) {
                lokaleListe.add(lokaleDArray[i][0]);
            }
            lokaleInnlastingList = FXCollections.observableArrayList(lokaleListe);
            lokaleComboBox.setValue(lokaleDArray[0][0]);
            lokaleComboBox.setItems(lokaleInnlastingList);
        }catch(Exception e){}

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
            if(lokLagringBox.getValue()== "Csv"){
                try{
                    CsvLagring fil = new CsvLagring();
                    fil.skriver(lokale,"lokale");
                }catch (IOException e){

                }
            }else if(lokLagringBox.getValue()== "Jobj"){
                try{
                    JobjLagring fil = new JobjLagring();
                    fil.skriver(lokale,"lokale");
                }catch (IOException e){

                }
            }
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
            Arrangement arrangement = new Arrangement(arrKontaktPerson.getText(), arrType.getText(), arrNavn.getText(), arrArtist.getText(),
                    arrProgram.getText(), arrTidspunkt.getText(), arrPris.getText(), arrAntallBilletter.getText(), arrLokale.getText());
            Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, eier, "Vellykket", "Arrangement er registrert");
            if(lokLagringBox.getValue()== "Csv"){
                try{
                    CsvLagring fil = new CsvLagring();
                    fil.skriver(arrangement,"arrangement");
                }catch (IOException e){

                }
            }else if(lokLagringBox.getValue()== "Jobj"){
                try{
                    JobjLagring fil = new JobjLagring();
                    fil.skriver(arrangement,"arrangement");
                }catch (IOException e){

                }
            }
        } catch (Exception e) {

        }
    }



}

