package sample;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Person> table = new TableView<Person>();
    @FXML
    private TableView<Person> tabellVisning= table;
    @FXML
    private TableColumn<Person, String> visningNavn;
    @FXML
    private TableColumn<Person, String> visningType;
    @FXML
    private TableColumn<Person, String> visningPris;
    @FXML
    private TableColumn<Person, String> visningDato;
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
    ObservableList<Person> dataa =
            FXCollections.observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com"));
    @FXML
    private void initialize() {
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
        ObservableList<String> nyListe=FXCollections.observableArrayList();


        try {

            for (int i = 0; i < arrArray.length; i++) {
                arrListe.add(arrDArray[i][0]);
                arrType.add(arrDArray[i][12]);
                arrPrisListe.add(arrDArray[i][4]);
                arrTidspunktListe.add(arrDArray[i][3]);
            }
            arrInnlastingList = FXCollections.observableArrayList(arrListe);
        }catch(Exception e){}

        try{
            for(int i=0; i< arrArray.length;i++){
                nyListe.add(arrDArray[i][0] +", "+arrDArray[i][12]+", "+arrDArray[i][4]+ ", "+arrDArray[i][3]);
            }
        }catch(Exception e){}
        if(arrDArray != null) {
            billettComboBox.setItems(arrInnlastingList);
            billettComboBox.setValue(arrDArray[0][0]);
            billettPris.setText(arrDArray[0][4]);
            billettLokal.setText(arrDArray[0][11]);
            billettTidspunkt.setText(arrDArray[0][3]);
            billettLedig.setText(arrDArray[0][14]);

            visningNavn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            visningType.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            visningPris.setCellValueFactory(new PropertyValueFactory<>("email"));
            visningDato.setCellValueFactory(new PropertyValueFactory<>("Dato"));

            tabellVisning.setItems(dataa);
            tabellVisning.getColumns().setAll(visningNavn, visningType,visningPris,visningDato);

        }


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
    /*
    *
    * *
    *  Kontroller for Arrangement visning
    *
    *
    */


    /*
     *
     * Kontroller for billett************************************************************************'***
     *
     * */

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
        }catch(Exception e){

        }
        try {
            endreBillett.billettSolgt("csv", x);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeilFilFormatException e) {
            e.printStackTrace();
        }
        try{
            arrListe.clear();
            initialize();
        }catch (Exception e){

        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, salg, "Vellykket", "Billett registrert på telefonnummer");
        ComboBox<Object> salgBox = new ComboBox<Object>();

    }

}
