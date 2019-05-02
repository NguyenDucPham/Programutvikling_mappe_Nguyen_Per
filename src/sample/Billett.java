package sample;

import java.io.IOException;
import java.io.Serializable;

public class Billett implements Serializable {
    private static final long serialVersionUID = 2;

    private String lokaleNavn;
    private String plassNummer;
    private String pris;
    private String tlfNummer;
    private String dato;
    private String klokkeslett;
    private String arrangementNavn;


    public Billett(String plassNummer, String lokaleNavn, String pris, String tlfNummer, String dato, String klokkeslett,
                   String arrangementNavn) {
        this.plassNummer = plassNummer;
        this.lokaleNavn = lokaleNavn;
        this.pris = pris;
        this.tlfNummer = tlfNummer;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.arrangementNavn = arrangementNavn;
    }

    public void billettSolgt(String format, int index) throws IOException, InvalidFileFormatException {
        FilEndring filEndring;
        if (format.equals("csv")) {
            filEndring = new CsvEndring();
        } else {
            filEndring = new JobjEndring();
        }
        filEndring.elementEndrer("arrangement", index);
    }

    @Override
    public String toString() {
        return plassNummer + ";" + lokaleNavn + ";" + pris + ";" + tlfNummer + ";" + dato + ";" + klokkeslett
                + ";" + arrangementNavn;
    }
}
