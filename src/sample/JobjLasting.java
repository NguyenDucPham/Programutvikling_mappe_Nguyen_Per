package sample;


import sample.FilLasting;

import java.io.*;
import java.util.ArrayList;

public class JobjLasting extends FilLasting {
    @Override
    public String leser(String fil) throws IOException, FeilFilFormatException, ClassNotFoundException {
        StringBuilder strengBygger = new StringBuilder();
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            objekter = (ArrayList<Object>) objektInnputStroem.readObject();
            for (Object objekt : objekter) {
                strengBygger.append(objekt.toString());
                strengBygger.append("\n");
                //if (!objekt.equals(Arrangement.class) || !objekt.equals(Billett.class))
                //   throw new FeilFilFormatException("Filen har feil format");
            }
            return strengBygger.toString();
        }
        return null;
    }
}
