package sample;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CsvLasting extends FilLasting{
    @Override
    public String leser(String fil) throws InvalidFileFormatException,IOException {
        String data = null;
        String s;
        RandomAccessFile leser = new RandomAccessFile(fil+".csv","r" );
        while ((s=(leser.readLine())) != null){
            if(data == null){
                data = s + "\n";
            }else{
                data = data + s + "\n";
            }
        }
        if(false) throw new InvalidFileFormatException("Filen er ikke separert med semikolon");
        return data;
    }
}
