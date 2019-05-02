package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import sample.CsvLasting;

import java.io.IOException;

public class InnlastingJobjThread extends Task {
    @FXML
    private ComboBox lokaleComboBox;
    private ObservableList<String>javel;
    @Override
    protected String call() throws IOException, FeilFilFormatException, ClassNotFoundException {
        JobjLasting innlasting = new JobjLasting();
        String lokaleString = null;
        lokaleString = innlasting.leser("arrangement");
        return lokaleString;
    }
}
