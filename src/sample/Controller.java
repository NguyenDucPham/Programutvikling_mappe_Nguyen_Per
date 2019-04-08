package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class Controller {
    @FXML
    private TextField lokalNavn;

    @FXML
    private TextField lokalType;

    @FXML
    private TextField antallPlasser;

    @FXML
    private Button registrer;

    @FXML
    protected void registrerTrykk(ActionEvent hendelse) {
        Window owner = registrer.getScene().getWindow();
        if(lokalNavn.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn navn");
            return;
        }
        if(lokalType.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn type lokale");
            return;
        }
        if(antallPlasser.getText().isEmpty()) {
            Beskjed.visVarsel(Alert.AlertType.ERROR, owner, "Form Error!", "Fyll inn antall plasser");
            return;
        }

        Beskjed.visVarsel(Alert.AlertType.CONFIRMATION, owner, "Vellykket","Lokalet er registrert" );
    }


}

