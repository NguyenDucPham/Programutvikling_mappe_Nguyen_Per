package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Kontroller {


    String[] lokaleArray;
    String[][] lokaleDArray;
   // ArrayList<String> lokaleListe=new ArrayList<>();
    ObservableList<String> lokaleInnlastingList = FXCollections.observableArrayList();





    @FXML
    private void initialize() {
    }



/*
        CsvLasting innlasting = new CsvLasting();
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
        }catch(Exception e){}


        CsvLasting kontaktInnlasting = new CsvLasting();
        String kontaktString = kontaktInnlasting.leser("kontakt");
        String[] kontaktArray = Splittere.linjeSplitter(kontaktString);
        String[][] kontaktDArray = Splittere.objectSplitter(kontaktArray);
        ObservableList<String> kontaktInnlastingList = FXCollections.observableArrayList();
        try {
            ArrayList<String> kontaktListe=new ArrayList<>();
            for (int i = 0; i < kontaktArray.length; i++) {
                kontaktListe.add(kontaktDArray[i][0]);
            }
            kontaktInnlastingList = FXCollections.observableArrayList(kontaktListe);
            kontaktComboBox.setValue(kontaktDArray[0][0]);
            kontaktComboBox.setItems(kontaktInnlastingList);
        }catch(Exception e){}




    public void init(String[][] lokaleDArray, String[] lokaleArray,ObservableList<String> lokaleInnlastingList){
        this.lokaleArray=lokaleArray;
        this.lokaleDArray=lokaleDArray;
        this.lokaleInnlastingList=lokaleInnlastingList;
    System.out.println(lokaleInnlastingList);

    }
*/

    /*
    *
    * Kontroller for arrangement****************************************************************************
    *
    * */
    @FXML
    private TextField arrNavn;

    @FXML
    private TextField arrProgram;

    @FXML
    private TextField arrArtist;

    @FXML
    private TextField arrTidspunkt;

    @FXML
    private TextField arrPris;

    @FXML
    private TextField konNavn;

    @FXML
    private TextField konTelefonnummer;

    @FXML
    private TextField konEkstraopplysning;

    @FXML
    private TextField konNettside;

    @FXML
    private TextField konFirma;

    @FXML
    private TextField lokNavn;

    @FXML
    private TextField lokType;

    @FXML
    private TextField lokAntallplasser;

    @FXML
    private Button arrRegistrerKnapp;

    @FXML
    private TextField arrAntallBilletter;

    @FXML
    private TextField konEmail;

    @FXML
    protected void arrReg(ActionEvent event) {
        Window eier = arrRegistrerKnapp.getScene().getWindow();

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
        if (konNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn navn");
            return;
        }
        if (konTelefonnummer.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn telefonnummer");
            return;
        }
        if (konEkstraopplysning.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn ekstraopplysning");
            return;
        }
        if (konNettside.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn nettside");
            return;
        }
        if (konFirma.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn firmanavn");
            return;
        }
        if (lokNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn navn");
            return;
        }
        if (lokType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn type");
            return;
        }
        if (lokAntallplasser.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, eier, "Form Error!", "Fyll inn antall plasser");
            return;
        }
        ComboBox<Object> arrComboBox= new ComboBox<Object>();
        try {
            Arrangement arrangement = new Arrangement(arrNavn.getText(), arrArtist.getText(), arrProgram.getText(), arrTidspunkt.getText(),
                    arrPris.getText(), konNavn.getText(), konTelefonnummer.getText(), konEmail.getText(), konEkstraopplysning.getText(),
                    konNettside.getText(), konFirma.getText(), lokNavn.getText(), lokType.getText(), lokAntallplasser.getText());
                    Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, eier, "Vellykket", "Arrangement er registrert");
            if(lokLagringBox.getValue()== "Csv"){
                CsvLagring fil = new CsvLagring();
                fil.skriver(arrangement,"arrangement");
            }else if(lokLagringBox.getValue()== "Jobj"){
                JobjLagring fil2 = new JobjLagring();
                fil2.skriver(arrangement,"arrangement");
            }
        } catch (Exception e) {

        }
    }

    /*
     *
     * Kontroller for billett************************************************************************'***
     *
     * */
    @FXML
    private TextField kjoperensTlf;
    @FXML
    private Button regSalg;
    @FXML
    private Text hentetPris;
    @FXML
    private Text hentetTidspunkt;
    @FXML
    private Text hentetLokal;

    @FXML
    protected void regSalg(ActionEvent event){
        Window salg = regSalg.getScene().getWindow();
        if (kjoperensTlf.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Form Error!", "Fyll inn telefonnummer");
            return;
        }
        ComboBox<Object> salgBox = new ComboBox<Object>();


    }
}
