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
import java.util.List;

public class Metoder {
    public static String[][] billettTrekker(String[][] matrise, int indeks){
        String antallBilett = matrise[indeks][14];
        int tallBillett = Integer.parseInt(antallBilett) - 1;
        antallBilett = String.valueOf(tallBillett);
        matrise[indeks][14] = antallBilett;
        return matrise;
    }

    public static ArrayList<Tabell> tabellListe(String[] liste){
        ArrayList<Tabell> arrangementListe = new ArrayList<>();
        String[][] matrise = Splittere.objectSplitter(liste);
        for(int i = 0; i < liste.length;i++){
            arrangementListe.add(new Tabell(matrise[i][0],matrise[i][12],matrise[i][4],matrise[i][3]));
        }

        return arrangementListe;
    }
    public static String opplysning(){
        return "Velkommen til Kulturhuset" +"\n"+
                "Her er det oversikt over arrangementer til kulturhuset" +"\n"+
                "kommuner har fått et nytt kulturhus med kinosal, teatersal og forsamlingssal.\n";
    }

}
