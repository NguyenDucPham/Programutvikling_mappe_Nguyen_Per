package sample;


import java.io.*;
import java.util.ArrayList;

public class JobjLasting extends FilLasting implements Serializable{
    @Override
    public String leser(String fil) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Object> objects = new ArrayList<Object>();
        if(new File(fil+".jobj").exists()) {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            try {
                objects = (ArrayList<Object>) oin.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        for (Object o : objects) {
            stringBuilder.append(o.toString());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
