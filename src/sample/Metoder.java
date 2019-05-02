package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Metoder {
    public static String[][] billettTrekker(String[][] matrise, int indeks){
        String antallBilett = matrise[indeks][14];
        int tallBillett = Integer.parseInt(antallBilett) - 1;
        antallBilett = String.valueOf(tallBillett);
        matrise[indeks][14] = antallBilett;
        return matrise;
    }

    public ObservableList<String> fxmlLasting()throws Exception{
        ArrayList<String> arrListe = new ArrayList<>();
        String[] arrArray;
        String[][] arrDArray;
        String last;
        ComboBox billettComboBox;
        InnlastingThread test= new InnlastingThread();
        last=test.call();
        arrArray = Splittere.linjeSplitter(last);
        arrDArray = Splittere.objectSplitter(arrArray);
        ObservableList<String> arrInnlastingList = FXCollections.observableArrayList();

        try {

            for (int i = 0; i < arrArray.length; i++) {
                arrListe.add(arrDArray[i][0]);
            }
            arrInnlastingList = FXCollections.observableArrayList(arrListe);
        }catch(Exception e){}

        return arrInnlastingList;
    }

}
