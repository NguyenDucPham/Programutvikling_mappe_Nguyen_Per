package sample;

import java.io.IOException;

public abstract class FilSletting {
    public abstract void sletter(String fil, int indeks)throws FeilFilFormatException, IOException;
}
