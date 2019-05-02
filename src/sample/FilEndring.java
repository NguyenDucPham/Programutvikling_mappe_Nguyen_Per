package sample;

import java.io.IOException;

public abstract class FilEndring {
    public abstract void elementEndrer(String fil, int indeks) throws IOException, FeilFilFormatException, Exception;
}
