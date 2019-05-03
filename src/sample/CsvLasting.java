package sample;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CsvLasting extends FilLasting{
    @Override
    public String leser(String fil) throws FeilFilFormatException,IOException {
        String data = null;
        String s;
        String[] formatTester;
        if (new File(fil + ".csv").exists()) {
            RandomAccessFile leser = new RandomAccessFile(fil + ".csv", "r");

            while ((s = (leser.readLine())) != null) {
                //formatTester = s.split(";");
                /*if ((formatTester.length !=15 && fil.equals("arrangement")) ||
                        (formatTester.length !=7 && fil.equals("billett")))
                        throw new FeilFilFormatException("Filen er ikke separert riktig");*/
                if (data == null) {
                    data = s + "\n";
                } else {
                    data = data + s + "\n";
                }
            }
        }
        return data;
    }
}
