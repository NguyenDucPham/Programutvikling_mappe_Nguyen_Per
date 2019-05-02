package sample;

import java.io.*;

public class CsvLagring extends FilLagring {
    @Override
    public void skriver(Object objekt, String filPlassering) throws IOException {
        /*****
         *   FileWriter bestemmer fil og true sier at den skal legge til om filen finnes,
         *   BufferedWriter får opp effektiviteten ved enkelte tilfeller,
         *   PrintWriter gir tilgang til println.
         *****/
        PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(filPlassering + ".csv", true)));
        skriver.println(objekt.toString());
        skriver.close();
    }
}
