package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CsvLasting extends FilLasting{
    @Override
    public String leser(String fil){
        String data = null;
        String s;
        try{
            RandomAccessFile leser = new RandomAccessFile(fil+".csv","r" );
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
    }
}
