package sample;

import java.io.IOException;
import java.io.PrintWriter;

public class JobjLagring extends FilLagring{
    @Override
    public void skriver(Object object, String filPlassering) throws IOException {
        PrintWriter skriver;
        skriver = new PrintWriter(filPlassering+".jobj","UTF-8");
        skriver.println(object);

        if(skriver != null){
            skriver.close();
        }
    }
}
