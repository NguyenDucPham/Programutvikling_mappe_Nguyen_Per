package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class JobjLagring extends FilLagring{
    @Override
    public void skriver(Object object, String filPlassering) throws IOException {
        try(FileWriter filSkriver = new FileWriter(filPlassering+".jobj", true);
            BufferedWriter bufferSkriver = new BufferedWriter(filSkriver);
            PrintWriter skriver = new PrintWriter(bufferSkriver))
        {
            skriver.println(object.toString());

            if(skriver != null){
                skriver.close();
            }
        } catch (IOException e) {

        }
    }
}
