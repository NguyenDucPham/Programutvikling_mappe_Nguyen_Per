package sample;

import sample.FilSletting;

import java.io.*;
import java.util.ArrayList;

public class JobjSletting extends FilSletting {
    @Override
    public void sletter(String fil, int indeks) throws FeilFilFormatException, IOException,ClassNotFoundException {
        ArrayList<Object> objekter = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            objekter = (ArrayList<Object>) objektInnputStroem.readObject();
        }
        objekter.remove(indeks);
        Object objekt = null;
        ObjectOutputStream objektUtStroem = new ObjectOutputStream(new FileOutputStream(fil + ".jobj"));
        if(objekter.size() != 0) {
            objektUtStroem.writeObject(objekter);
        }else{
            objekter.add(objekt);
            objektUtStroem.writeObject(objekter);
        }
        objektUtStroem.close();
    }
}
