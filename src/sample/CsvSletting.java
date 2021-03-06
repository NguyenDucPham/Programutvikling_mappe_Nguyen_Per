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
        ArrayList<String> rekkeListe = new ArrayList<>(Arrays.asList(rekke));
        rekkeListe.remove(indeks);
        for(int i = 0; i < rekkeListe.size();i++){
            if(ut == null){
                ut = rekkeListe.get(i);
            }else {
                ut = ut + "\n" + rekkeListe.get(i);
            }
        }
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(fil + ".csv")));
        if(ut==null){
            skriver.close();
        }
        skriver.println(ut);
        skriver.close();

    }
}
