package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvSletting extends FilSletting{
    @Override
    public void sletter(String fil, int indeks) throws FeilFilFormatException, IOException {
        String ut = null;
        CsvLasting csvLasting = new CsvLasting();
        String inn = csvLasting.leser(fil);
        String[] rekke = Splittere.linjeSplitter(inn);
        System.out.println(rekke);
        ArrayList<String> rekkeListe = new ArrayList<>(Arrays.asList(rekke));
        System.out.println(rekkeListe);
        rekkeListe.remove(indeks);
        System.out.println(rekkeListe);
        System.out.println(ut);
        for(int i = 0; i < rekkeListe.size();i++){
            if(ut == null){
                ut = rekkeListe.get(i);
            }else {
                ut = ut + "\n" + rekkeListe.get(i);
            }
        }
        System.out.println(ut);
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(fil + ".csv")));
        skriver.println(ut);
        skriver.close();

    }
}
