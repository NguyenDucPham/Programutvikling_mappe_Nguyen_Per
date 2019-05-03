package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import sample.CsvLasting;

import java.io.IOException;

public class InnlastingThread extends Task {

    @Override
    protected String call() throws IOException, FeilFilFormatException {
        CsvLasting innlasting = new CsvLasting();
        String lokaleString = null;
        lokaleString = innlasting.leser("arrangement");
        return lokaleString;
    }
}
