package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Window;
import java.io.IOException;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.xml.stream.FactoryConfigurationError;
public class Kontroller {

    private final ObservableList<String> data = FXCollections.observableArrayList();
    @FXML
    private TextArea opplysningsVirksomhet;
    @FXML
    private TableView<Tabell> table = new TableView<>();
    @FXML
    private TableView<Tabell> tabellVisning= table;
    @FXML
    private TableColumn<Tabell, String> visningNavn;
    @FXML
    private TableColumn<Tabell, String> visningType;
    @FXML
    private TableColumn<Tabell, String> visningPris;
    @FXML
    private TableColumn<Tabell, String> visningDato;
    @FXML
    private ComboBox billettComboBox;
    @FXML
    private TextField kjoperensTlf;
    @FXML
    private Button regSalg;
    @FXML
    private Text billettTidspunkt;
    @FXML
    private Text billettLokal;
    @FXML
    private Text billettPris;
    @FXML
    private Text billettLedig;
    private ArrayList <String> arrPrisListe = new ArrayList<>();
    private ArrayList<String> arrTidspunktListe = new ArrayList<>();
    private ArrayList<String> arrType=new ArrayList<>();
    private ArrayList<String> arrListe = new ArrayList<>();
    private String[] arrArray;
    private String[][] arrDArray;
    private int indeks = -1;


    @FXML
    private void initialize() {
        opplysningsVirksomhet.setText(Metoder.opplysning());
        tabellVisning.setEditable(true);
        String last = null;
        InnlastingThread test= new InnlastingThread();
        try {
            last=test.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(last != null) {
            arrArray = Splittere.linjeSplitter(last);
            arrDArray = Splittere.objectSplitter(arrArray);
            ObservableList<String> arrInnlastingList = FXCollections.observableArrayList();

            try {

                for (int i = 0; i < arrArray.length; i++) {
                    arrListe.add(arrDArray[i][0]);
                    arrType.add(arrDArray[i][12]);
                    arrPrisListe.add(arrDArray[i][4]);
                    arrTidspunktListe.add(arrDArray[i][3]);
                }
                arrInnlastingList = FXCollections.observableArrayList(arrListe);
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (arrDArray != null) {
                billettComboBox.setItems(arrInnlastingList);
                billettComboBox.setValue(arrDArray[0][0]);
                billettPris.setText(arrDArray[0][4]);
                billettLokal.setText(arrDArray[0][11]);
                billettTidspunkt.setText(arrDArray[0][3]);
                billettLedig.setText(arrDArray[0][14]);


                ObservableList<Tabell> dataa = FXCollections.observableArrayList(Metoder.tabellListe(arrArray));
                visningNavn.setCellValueFactory(new PropertyValueFactory<>("navn"));
                visningType.setCellValueFactory(new PropertyValueFactory<>("lokaleType"));
                visningPris.setCellValueFactory(new PropertyValueFactory<>("pris"));
                visningDato.setCellValueFactory(new PropertyValueFactory<>("tidspunkt"));

                tabellVisning.setItems(dataa);
                tabellVisning.getColumns().setAll(visningNavn, visningType, visningPris, visningDato);

            }
            visningNavn.setCellFactory(TextFieldTableCell.forTableColumn());
            visningDato.setCellFactory(TextFieldTableCell.forTableColumn());
            visningType.setCellFactory(TextFieldTableCell.forTableColumn());
            visningPris.setCellFactory(TextFieldTableCell.forTableColumn());


            tabellVisning.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    indeks = tabellVisning.getSelectionModel().getSelectedIndex();
                }
            });
        }else{
            billettComboBox.setItems(null);
            billettPris.setText(null);
            billettLokal.setText(null);
            billettTidspunkt.setText(null);
            billettLedig.setText(null);

            ObservableList<Tabell> dataa = FXCollections.observableArrayList();
            visningNavn.setCellValueFactory(new PropertyValueFactory<>("navn"));
            visningType.setCellValueFactory(new PropertyValueFactory<>("lokaleType"));
            visningPris.setCellValueFactory(new PropertyValueFactory<>("pris"));
            visningDato.setCellValueFactory(new PropertyValueFactory<>("tidspunkt"));

            tabellVisning.setItems(dataa);
            tabellVisning.getColumns().setAll(visningNavn, visningType, visningPris, visningDato);

            visningNavn.setCellFactory(TextFieldTableCell.forTableColumn());
            visningDato.setCellFactory(TextFieldTableCell.forTableColumn());
            visningType.setCellFactory(TextFieldTableCell.forTableColumn());
            visningPris.setCellFactory(TextFieldTableCell.forTableColumn());


            tabellVisning.setOnMouseClicked((MouseEvent event) -> {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    indeks = tabellVisning.getSelectionModel().getSelectedIndex();
                }
            });
        }

    }
    @FXML
    public void updateValues(){
        try {
            String hentetArr = (String) billettComboBox.getValue();
            for (int i = 0; i < arrArray.length; i++) {
                if (arrDArray[i][0].equals(hentetArr)){
                    billettPris.setText(arrDArray[i][4]);
                    billettLokal.setText(arrDArray[i][11]);
                    billettTidspunkt.setText(arrDArray[i][3]);
                    billettLedig.setText(arrDArray[i][14]);

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

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
        Window registrer = arrRegistrerKnapp.getScene().getWindow();

        if (arrNavn.getText().isEmpty()||arrNavn.getText().matches("[0-9,;]*")) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn riktig format");
            return;
        }
        if (arrProgram.getText().isEmpty()||testSemi(arrProgram.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn Program");
            return;
        }
        if (arrArtist.getText().isEmpty()||testSemi(arrArtist.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn artist");
            return;
        }
        if (arrTidspunkt.getText().isEmpty()||testSemi(arrTidspunkt.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn tidspunkt");
            return;
        }

        if (arrPris.getText().isEmpty()||testSemi(arrPris.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn pris");
            return;
        }
        if (konNavn.getText().isEmpty()||testSemi(konNavn.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn navn");
            return;
        }
        if (konTelefonnummer.getText().isEmpty()||testSemi(konTelefonnummer.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn telefonnummer");
            return;
        }
        if (konEkstraopplysning.getText().isEmpty()||testSemi(konEkstraopplysning.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn ekstraopplysning");
            return;
        }
        if (konNettside.getText().isEmpty()||testSemi(konNettside.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn nettside");
            return;
        }
        if (konFirma.getText().isEmpty()||testSemi(konFirma.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn firmanavn");
            return;
        }
        if (lokNavn.getText().isEmpty()||testSemi(lokNavn.getText())){
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn lokalet");
            return;
        }
        if (lokType.getText().isEmpty()||testSemi(lokType.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Fyll inn type");
            return;
        }
        if (lokAntallplasser.getText().isEmpty()||lokAntallplasser.getText().matches("[a-z,A-Z]*")||testSemi(lokAntallplasser.getText())) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Feil input, kunn Tall");
            return;
        }

        try {
            Arrangement arrangement = new Arrangement(arrNavn.getText(), arrArtist.getText(), arrProgram.getText(), arrTidspunkt.getText(),
                    arrPris.getText(), konNavn.getText(), konTelefonnummer.getText(), konEmail.getText(), konEkstraopplysning.getText(),
                    konNettside.getText(), konFirma.getText(), lokNavn.getText(), lokType.getText(), lokAntallplasser.getText(), lokAntallplasser.getText());
                    Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, registrer, "Vellykket", "Arrangement er registrert");
            CsvLagring csvLagring = new CsvLagring();
            csvLagring.skriver(arrangement,"arrangement");
            try {
                arrListe.clear();
                initialize();
            }catch (Exception e){
                Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Problemer med å " +
                        "relaste siden");
            }
        } catch (IOException e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, registrer, "Feil!", "Problemer med å laste/lagre");
        }
    }
    private boolean testSemi(String text){
        return text.matches("[;]*");

    }

    @FXML
    protected void registrerSalg(ActionEvent event){
        Window salg = regSalg.getScene().getWindow();
        if (kjoperensTlf.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Feil!", "Fyll inn telefonnummer");
            return;
        }
        Billett endreBillett = new Billett();
        int x=0;
        try {
            String hentetArr = (String) billettComboBox.getValue();
            for (int i = 0; i < arrArray.length; i++) {
                if (arrDArray[i][0].equals(hentetArr)){
                    x=i;

                }
            }
        }catch (Exception e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Feil!", "Noe gikk galt");
            return;
        }
        try {
            endreBillett.billettSolgt("csv", x);
        } catch (IOException e) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Feil!", "Problemer med å laste/lagre");
            return;
        } catch (FeilFilFormatException e) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Feil!", "Filen har feil format");
            return;
        }catch (Exception e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Feil!", "Det er tomt for billetter til " +
                    "dette arrangementet");
            return;
        }
        try{
            arrListe.clear();
            initialize();
        }catch (Exception e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Form Error!", "Problemer med å " +
                    "relaste siden");
            return;
        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, salg, "Vellykket", "Billett registrert på telefonnummer");
        ComboBox<Object> salgBox = new ComboBox<>();

    }

    @FXML
    protected void slettArrangement(ActionEvent event){
        Window slett = regSalg.getScene().getWindow();
        if (indeks==-1) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, slett, "Feil!", "Velg et " +
                    "arrangement du vil slette");
            return;
        }

        CsvSletting csvSletting = new CsvSletting();
        try{
            csvSletting.sletter("arrangement",indeks);
        }catch (IOException e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, slett, "Feil!", "Problemer med å laste/lagre");
            return;
        }catch (FeilFilFormatException e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, slett, "Feil!", "Filen har feil format");
            return;
        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, slett, "Vellykket", "Arrangementet er slettet");
        ComboBox<Object> salgBox = new ComboBox<>();
        arrListe.clear();
        initialize();
    }
}
