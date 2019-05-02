package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.ArrayList;
import javafx.concurrent.Task;

public class InnlastingThread extends Task {
    @FXML
    private ComboBox lokaleComboBox;
    private ObservableList<String>javel;
    @Override
    protected String call() throws Exception {
        CsvLasting innlasting = new CsvLasting();
        String lokaleString = null;
        try {
            lokaleString = innlasting.leser("lokale");
        } catch (IOException e){
            e.printStackTrace();
        }catch (InvalidFileFormatException e) {

        }
        return lokaleString;

    }

}
