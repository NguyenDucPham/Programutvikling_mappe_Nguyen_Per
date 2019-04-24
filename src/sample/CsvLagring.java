package sample;

import java.io.*;

public class CsvLagring extends FilLagring{
    @Override
    public void skriver(Object object, String filPlassering){
        try(FileWriter filSkriver = new FileWriter(filPlassering+".csv", true);
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
