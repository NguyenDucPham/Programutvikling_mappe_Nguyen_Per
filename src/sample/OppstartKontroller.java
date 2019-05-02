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

        Parent root;
        Window denne = oppstartBekreft.getScene().getWindow();
        if (oppstartComboBox.getValue() == "Csv") {
            try {
                root = FXMLLoader.load(getClass().getResource("Tab.fxml"));
                Stage stage = new Stage();
                stage.setTitle("My New Stage Title");
                stage.setScene(new Scene(root, 900, 900));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (oppstartComboBox.getValue() == "Jobj") {


        } else Beskjed.visVarsel(Alert.AlertType.ERROR, denne, "Form Error!", "Noe galt med innput");


    }
}


