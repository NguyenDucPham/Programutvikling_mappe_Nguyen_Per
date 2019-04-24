package sample;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FilLagring{

    public void skriver(Object object, String filPlassering ) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter skriver = null;
        skriver = new PrintWriter(filPlassering,".csv");
        skriver.println(object);
    }
/*
    skriver = new PrintWriter(filplassering,".csv");
    skriver.println(object);
*/
}
