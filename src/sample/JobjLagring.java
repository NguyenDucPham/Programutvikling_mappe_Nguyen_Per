package sample;

import java.io.*;
import java.util.ArrayList;

public class JobjLagring extends FilLagring implements Serializable {
    @Override
    public void skriver(Object objekt, String filPlassering) throws IOException {
        ObjectOutputStream objektUtStroem;
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(filPlassering + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(filPlassering + ".jobj"));
            try {
                objekter = (ArrayList<Object>) objektInnputStroem.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        objekter.add(objekt);
        objektUtStroem = new ObjectOutputStream(new FileOutputStream(filPlassering + ".jobj"));
        objektUtStroem.writeObject(objekter);
    }
}
