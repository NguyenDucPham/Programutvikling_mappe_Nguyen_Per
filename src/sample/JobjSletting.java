package sample;

import java.io.*;
import java.util.ArrayList;

public class JobjSletting extends FilSletting{
    @Override
    public void sletter(String fil, int indeks) throws FeilFilFormatException, IOException {
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            try {
                objekter = (ArrayList<Object>) objektInnputStroem.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        objekter.remove(indeks);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fil + ".jobj"));
        out.writeObject(objekter);
    }
}
