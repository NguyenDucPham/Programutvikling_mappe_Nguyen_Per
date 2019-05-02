package sample;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CsvLasting extends FilLasting{
    @Override
    public String leser(String fil) throws FeilFilFormatException,IOException {
        String data = null;
        String s;
        if (new File(fil + ".csv").exists()) {
            RandomAccessFile leser = new RandomAccessFile(fil + ".csv", "r");
            while ((s = (leser.readLine())) != null) {
                if (data == null) {
                    data = s + "\n";
                } else {
                    data = data + s + "\n";
                }
            }
        }
        if(false) throw new FeilFilFormatException("Filen er ikke separert med semikolon");
        return data;
    }
}
