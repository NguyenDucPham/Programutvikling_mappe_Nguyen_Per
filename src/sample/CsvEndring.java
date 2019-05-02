package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvEndring extends FilEndring{
    @Override
    public void elementEndrer(String fil, int indeks) throws IOException, FeilFilFormatException {
        int elementer = 0;
        String ut = null;
        System.out.println(fil);
        System.out.println(indeks);
        CsvLasting csvLasting = new CsvLasting();
        String[] rekke = Splittere.linjeSplitter(csvLasting.leser(fil+".csv"));
        String[][] matrise = Splittere.objectSplitter(rekke);
        matrise = Metoder.billettTrekker(matrise,indeks);
        if(fil.equals("arrangement")){
            elementer = 15;
        }else{
            elementer = 7;
        }
        for(int i = 0; i < rekke.length; i++){
            for (int j = 0; j < elementer; j++){
                if(i == 0){
                    ut = ut + matrise[i][j];
                }else if(i == rekke.length-1 && !(j == elementer-1)){
                    ut = ut + matrise[i][j] + "\n";
                }else{
                    ut = ut + matrise[i][j] + ";";
                }
            }
        }
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(fil + ".csv")));
        skriver.print(ut);
    }
}
