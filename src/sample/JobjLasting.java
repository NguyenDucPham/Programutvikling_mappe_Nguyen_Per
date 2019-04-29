package sample;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JobjLasting extends FilLasting{
    @Override
    public String[][] leser(String fil){
        String data = null;
        String s;
        try{
            RandomAccessFile leser = new RandomAccessFile(fil+".jobj","r" );
            while ((s=(leser.readLine())) != null){
                if(data == null){
                    data = s + "\n";
                }else{
                    data = data + s + "\n";
                }
            }
        }catch(FileNotFoundException e){

        }catch(IOException e){

        }
        System.out.println(data);
        return Splittere.objectSplitter(Splittere.linjeSplitter(data));
    }
}
