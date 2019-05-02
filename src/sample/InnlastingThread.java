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
    protected ObservableList<String> call() throws Exception {
        CsvLasting innlasting = new CsvLasting();
        String lokaleString = null;
        try {
            lokaleString = innlasting.leser("lokale");
        } catch (IOException e){
            e.printStackTrace();
        }catch (InvalidFileFormatException e) {

        }

        String[] lokaleArray = Splittere.linjeSplitter(lokaleString);
        String[][] lokaleDArray = Splittere.objectSplitter(lokaleArray);
        ObservableList<String> lokaleInnlastingList = FXCollections.observableArrayList();


        try {
            ArrayList<String> lokaleListe = new ArrayList<>();
            for (int i = 0; i < lokaleArray.length; i++) {
                lokaleListe.add(lokaleDArray[i][0]);
            }
            lokaleInnlastingList = FXCollections.observableArrayList(lokaleListe);

            Kontroller Kon = new Kontroller();
            Kon.setLokaleInnlastingList(lokaleInnlastingList);
            System.out.println("denne ble først kjørt");


            //Kon.init(lokaleDArray, lokaleArray, lokaleInnlastingList);
            System.out.println(lokaleInnlastingList);
            javel=lokaleInnlastingList;
            System.out.println(javel+"for faen");

        }catch(Exception e){}
        return lokaleInnlastingList;
    }


}
