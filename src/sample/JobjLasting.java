package sample;


import java.io.*;
import java.util.ArrayList;

public class JobjLasting extends FilLasting{
    @Override
    public String leser(String fil) throws IOException, InvalidFileFormatException {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Object> objects = new ArrayList<>();
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
        try {
            objects = (ArrayList<Object>) oin.readObject();
        } catch (ClassNotFoundException e) {

        }
        for (Object o : objects) {
            stringBuilder.append(o.toString());
            stringBuilder.append("\n");
        }
        if(false) throw new InvalidFileFormatException("Data er fra en utdatert versjon av klassen");
        return stringBuilder.toString();
    }
}
