package sample;

import java.io.*;
import java.util.ArrayList;

public class JobjEndring extends FilEndring{

    @Override
    public void elementEndrer(String fil, int index) throws IOException, InvalidFileFormatException {
        ArrayList<Object> objects = new ArrayList<>();
        if (new File(fil + ".jobj").exists()) {
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(fil + ".jobj"));
            try {
                objects = (ArrayList<Object>) oin.readObject();
            } catch (ClassNotFoundException e) {

            }
        }
        Object object;
        objects.remove(index);
        JobjLasting jobjLasting = new JobjLasting();
        String[] array = Splittere.linjeSplitter(jobjLasting.leser(fil+".jobj"));
        String[][] dArray = Splittere.objectSplitter(array);
        dArray = Metoder.billettTrekker(dArray,index);
        if(fil.equals("arrangement")){
            object = new Arrangement(dArray[index][0],dArray[index][1],dArray[index][2],dArray[index][3],dArray[index][4],
                    dArray[index][5],dArray[index][6],dArray[index][7],dArray[index][8],dArray[index][9],dArray[index][10],
                    dArray[index][11],dArray[index][12],dArray[index][13],dArray[index][14]);
        }else{
            object = new Billett(dArray[index][0],dArray[index][1],dArray[index][2],dArray[index][3],dArray[index][4],
                    dArray[index][5],dArray[index][6]);
        }
        objects.add(index,object);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fil + ".jobj"));
        out.writeObject(objects);
    }
}
