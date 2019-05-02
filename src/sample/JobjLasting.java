package sample;


import java.io.*;
import java.util.ArrayList;

public class JobjLasting extends FilLasting{
    @Override
    public String leser(String fil) throws IOException, FeilFilFormatException {
        StringBuilder strengBygger = new StringBuilder();
        ArrayList<Object> objekter = new ArrayList<>();
        ObjectInputStream objektInnputStroem = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
        try {
            objekter = (ArrayList<Object>) objektInnputStroem.readObject();
        } catch (ClassNotFoundException e) {

        }
        for (Object objekt : objekter) {
            strengBygger.append(objekt.toString());
            strengBygger.append("\n");
        }
        if(false) throw new FeilFilFormatException("Data er fra en utdatert versjon av klassen");
        return strengBygger.toString();
    }
}
