package sample;

import java.io.IOException;
import java.io.PrintWriter;

public abstract class FilLagring{

    public abstract void skriver(Object object, String filPlassering) throws IOException;
/*
    skriver = new PrintWriter(filplassering,".csv");
    skriver.println(object);
*/
}
