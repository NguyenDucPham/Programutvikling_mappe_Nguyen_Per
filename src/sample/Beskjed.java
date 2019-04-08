package sample;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class Beskjed  {

    public static void visVarsel(Alert.AlertType beskjedType, Window eier, String tittel, String beskjed) {
        Alert varsel = new Alert(beskjedType);
        varsel.setTitle(tittel);
        varsel.setHeaderText(null);
        varsel.setContentText(beskjed);
        varsel.initOwner(eier);
        varsel.show();
    }
}