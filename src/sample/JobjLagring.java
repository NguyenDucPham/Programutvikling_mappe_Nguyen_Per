package sample;

import java.io.*;
import java.util.ArrayList;

public class JobjLagring extends FilLagring implements Serializable{
    @Override
    public void skriver(Object object, String filPlassering) throws IOException {
        ObjectOutputStream out;
        ArrayList<Object> objects = new ArrayList<Object>();
        try{
            if(new File(filPlassering+".jobj").exists()){
                ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filPlassering + ".jobj"));
                try{
                    objects = (ArrayList<Object>)oin.readObject();
                }catch (ClassNotFoundException e){

                }
                objects.add(object);
                out = new ObjectOutputStream(new FileOutputStream(filPlassering+ ".jobj"));
            }else{
                out = new ObjectOutputStream(new FileOutputStream(filPlassering+ ".jobj"));
                objects.add(object);
            }
            out.writeObject(objects);
        }
        catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }
}
