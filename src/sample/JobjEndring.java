package sample;

import sample.FilEndring;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JobjEndring extends FilEndring {

    @Override
    public void elementEndrer(String fil, int indeks) throws IOException, FeilFilFormatException,Exception {
        ArrayList<Arrangement> objekter = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            try {
                objekter = (ArrayList<Arrangement>) objektInnputStroem.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        Arrangement arrangement;
        arrangement = objekter.get(indeks);
        arrangement.setAntallLedigeBilletter(Metoder.jobjBillettTrekker(arrangement.getAntallLedigeBilletter()));
        objekter.remove(indeks);
        objekter.add(indeks,arrangement);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fil + ".jobj"));
        out.writeObject(objekter);
    }
}
