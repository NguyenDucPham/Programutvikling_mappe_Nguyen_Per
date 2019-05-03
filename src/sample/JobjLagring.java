package sample;

import sample.FilLagring;

import java.io.*;
import java.util.ArrayList;

public class JobjLagring extends FilLagring implements Serializable {
    @Override
    public void skriver(Object objekt, String filPlassering) throws IOException,ClassNotFoundException {
        ObjectOutputStream objektUtStroem;
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(filPlassering + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(filPlassering + ".jobj"));
            objekter = (ArrayList<Object>) objektInnputStroem.readObject();
        }
        if (!objekter.isEmpty()){
            if(objekter.get(0) == null) {
                objekter.remove(0);
            }
        }
        objekter.add(objekt);
        objektUtStroem = new ObjectOutputStream(new FileOutputStream(filPlassering + ".jobj"));
        objektUtStroem.writeObject(objekter);
        objektUtStroem.close();
    }
}
