package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class CsvEndring extends FilEndring{
    @Override
    public void elementEndrer(String fil, int indeks) throws IOException, FeilFilFormatException {
        int elementer = 0;
        String ut = null;
        CsvLasting csvLasting = new CsvLasting();
        String inn = csvLasting.leser(fil);
        String[] rekke = Splittere.linjeSplitter(inn);
        String[][] matrise = Splittere.objectSplitter(rekke);
        matrise = Metoder.billettTrekker(matrise,indeks);
        if(fil.equals("arrangement")){
            elementer = 15;
        }else{
            elementer = 7;
        }
        for(int i = 0; i < rekke.length; i++){
            for (int j = 0; j < elementer; j++){
                if(j == 0){
                    if (ut == null){
                        ut = matrise[i][j];
                    }else {
                        ut = ut + matrise[i][j];
                    }
                }else if(!(i == rekke.length-1) && (j == elementer-1)){
                    ut = ut + ";" + matrise[i][j] + "\n";
                }else{
                    ut = ut + ";" + matrise[i][j];
                }
            }
        }
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(fil + ".csv")));
        skriver.println(ut);
        skriver.close();
    }
}
