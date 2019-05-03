package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class OppstartKontroller {

    ObservableList<String> list = FXCollections.observableArrayList("Csv", "Jobj");


    @FXML
    private Button oppstartBekreft;
    @FXML
    private ComboBox oppstartComboBox;

    @FXML
    private void initialize() {
        oppstartComboBox.setValue("Csv");
        oppstartComboBox.setItems(list);

    }

    @FXML
    public void startBekreft(ActionEvent event) {

        Parent rot;
        Window denne = oppstartBekreft.getScene().getWindow();
        if (oppstartComboBox.getValue() == "Csv") {
            try {
                rot = FXMLLoader.load(getClass().getResource("Tab.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Kulturhus");
                stage.setScene(new Scene(rot, 900, 900));
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (oppstartComboBox.getValue() == "Jobj") {
            try {
                rot = FXMLLoader.load(getClass().getResource("TabJobj.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Kulturhus");
                stage.setScene(new Scene(rot, 900, 900));
                stage.show();
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else Beskjed.visVarsel(Alert.AlertType.ERROR, denne, "Feil Oppdaget!", "Noe galt med innput");


    }
}


