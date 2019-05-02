package sample;

import sample.FilEndring;

import java.io.*;
import java.util.ArrayList;

public class JobjEndring extends FilEndring {

    @Override
    public void elementEndrer(String fil, int indeks) throws IOException, FeilFilFormatException,Exception {
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            try {
                objekter = (ArrayList<Object>) objektInnputStroem.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        Object objekt;
        objekter.remove(indeks);
        JobjLasting jobjLasting = new JobjLasting();
        String[] rekke = Splittere.linjeSplitter(jobjLasting.leser(fil+".jobj"));
        String[][] matrise = Splittere.objectSplitter(rekke);
        matrise = Metoder.billettTrekker(matrise,indeks);
        if(fil.equals("arrangement")){
            objekt = new Arrangement(matrise[indeks][0],matrise[indeks][1],matrise[indeks][2],matrise[indeks][3],matrise[indeks][4],
                    matrise[indeks][5],matrise[indeks][6],matrise[indeks][7],matrise[indeks][8],matrise[indeks][9],matrise[indeks][10],
                    matrise[indeks][11],matrise[indeks][12],matrise[indeks][13],matrise[indeks][14]);
        }else{
            objekt = new Billett(matrise[indeks][0],matrise[indeks][1],matrise[indeks][2],matrise[indeks][3],matrise[indeks][4],
                    matrise[indeks][5],matrise[indeks][6]);
        }
        objekter.add(indeks,objekt);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fil + ".jobj"));
        out.writeObject(objekter);
    }
}
