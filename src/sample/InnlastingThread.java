package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class InnlastingThread extends Task {
    @FXML
    private ComboBox lokaleComboBox;
    private ObservableList<String>javel;
    @Override
    protected String call() throws IOException, FeilFilFormatException {
        CsvLasting innlasting = new CsvLasting();
        String lokaleString = null;
        lokaleString = innlasting.leser("arrangement");
        return lokaleString;
    }
}
