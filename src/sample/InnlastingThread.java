package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class InnlastingThread implements Runnable{
    @FXML
    private ComboBox lokaleComboBox;




    public void run(){
        CsvLasting innlasting = new CsvLasting();
        String lokaleString = innlasting.leser("lokale");
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
            System.out.println("denne ble først kjørt");
            Kon.init(lokaleDArray, lokaleArray, lokaleInnlastingList);

        }catch(Exception e){}
    }
}
