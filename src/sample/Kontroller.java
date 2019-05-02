package sample;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.String.valueOf;

public class Kontroller {

    private final ObservableList<String> data = FXCollections.observableArrayList();
    @FXML
    private TextArea opplysningsVirksomhet;
    @FXML
    private TableView<Tabell> table = new TableView<Tabell>();
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
    private ArrayList <String> arrLokalListe= new ArrayList<>();
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
        }catch(Exception e){}


        if(arrDArray != null) {
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
            tabellVisning.getColumns().setAll(visningNavn, visningType,visningPris,visningDato);

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
        /*visningNavn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<Tabell, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<Tabell, String> t) {
                        ((Tabell) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setNavn(t.getNewValue());
                    }
                }
        );*/
    }
    @FXML
    public void updateValues(){
        try {
            String hentetArr = (String) billettComboBox.getValue();
            for (int i = 0; i < arrArray.length; i++) {
                if (arrDArray[i][0] == hentetArr){
                    billettPris.setText(arrDArray[i][4]);
                    billettLokal.setText(arrDArray[i][11]);
                    billettTidspunkt.setText(arrDArray[i][3]);
                    billettLedig.setText(arrDArray[i][14]);

                }
            }
        }catch(Exception e){

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
                    konNettside.getText(), konFirma.getText(), lokNavn.getText(), lokType.getText(), lokAntallplasser.getText(), lokAntallplasser.getText());
                    Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, eier, "Vellykket", "Arrangement er registrert");
            CsvLagring csvLagring = new CsvLagring();
            csvLagring.skriver(arrangement,"arrangement");
            try{
                arrListe.clear();
                initialize();
            }catch (Exception e){

            }
        } catch (Exception e) {

        }
    }


    @FXML
    protected void registrerSalg(ActionEvent event){
        Window salg = regSalg.getScene().getWindow();
        if (kjoperensTlf.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Form Error!", "Fyll inn telefonnummer");
            return;
        }
        Billett endreBillett = new Billett();
        int x=0;
        try {
            String hentetArr = (String) billettComboBox.getValue();
            for (int i = 0; i < arrArray.length; i++) {
                if (arrDArray[i][0] == hentetArr){
                    x=i;

                }
            }
        }catch (Exception e){

        }
        try {
            endreBillett.billettSolgt("csv", x);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeilFilFormatException e) {
            e.printStackTrace();
        }catch (Exception e){
            Beskjed.visVarsel(Alert.AlertType.ERROR, salg, "Form Error!", "Det er tomt for billetter til " +
                    "dette arrangementet");
            return;
        }
        try{
            arrListe.clear();
            initialize();
        }catch (Exception e){

        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, salg, "Vellykket", "Billett registrert på telefonnummer");
        ComboBox<Object> salgBox = new ComboBox<Object>();

    }

    @FXML
    protected void slettArrangement(ActionEvent event){
        Window slett = regSalg.getScene().getWindow();
        if (indeks==-1) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, slett, "Form Error!", "Velg et " +
                    "arrangement du vil slette");
            return;
        }
        /*
        try {
            String hentetArr = (String) billettComboBox.getValue();
            for (int i = 0; i < arrArray.length; i++) {
                if (arrDArray[i][0] == hentetArr){
                    x=i;

                }
            }
        }catch(Exception e){

        }*/
        CsvSletting csvSletting = new CsvSletting();
        try{
            csvSletting.sletter("arrangement",indeks);
        }catch (IOException e){

        }catch (FeilFilFormatException e){

        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, slett, "Vellykket", "Arrangementet er slettet");
        ComboBox<Object> salgBox = new ComboBox<Object>();
        arrListe.clear();
        initialize();
    }
}
