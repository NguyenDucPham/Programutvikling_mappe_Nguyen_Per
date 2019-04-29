package sample;

import java.io.*;

public class JobjLagring extends FilLagring{
    @Override
    public void skriver(Object object, String filPlassering){
        /*****
         *   FileWriter bestemmer fil og true sier at den skal legge til om filen finnes,
         *   BufferedWriter får opp effektiviteten ved enkelte tilfeller,
         *   PrintWriter gir tilgang til println.
         *****/
        try {
            PrintWriter skriver = new PrintWriter(new BufferedWriter(new FileWriter(filPlassering+".jobj", true)));
            skriver.println(object.toString());
            skriver.close();
        } catch (IOException e) {

        }
    }
}
