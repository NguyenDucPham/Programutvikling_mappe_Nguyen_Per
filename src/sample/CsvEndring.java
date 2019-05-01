package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvEndring extends FilEndring{
    @Override
    public void elementEndrer(String fil, int index) throws IOException, InvalidFileFormatException {
        int elementer = 0;
        String ut = null;
        CsvLasting csvLasting = new CsvLasting();
        String[] array = Splittere.linjeSplitter(csvLasting.leser(fil+".csv"));
        String[][] dArray = Splittere.objectSplitter(array);
        dArray = Metoder.billettTrekker(dArray,index);
        if(fil.equals("arrangement")){
            elementer = 15;
        }else{
            elementer = 7;
        }
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < elementer; j++){
                if(i == 0){
                    ut = ut + dArray[i][j];
                }else if(i == array.length-1 && !(j == elementer-1)){
                    ut = ut + dArray[i][j] + "\n";
                }else{
                    ut = ut + dArray[i][j] + ";";
                }
            }
        }
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(fil + ".csv")));
        skriver.print(ut);
    }
}
