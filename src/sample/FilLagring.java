package sample;

import java.io.IOException;

public abstract class FilLagring{

    public abstract void skriver(Object objekt, String filPlassering) throws IOException, ClassNotFoundException;

}
