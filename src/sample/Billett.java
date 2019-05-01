package sample;

import java.io.IOException;
import java.io.Serializable;

public class Billett implements Serializable {
    private static final long serialVersionUID = 2;

    private String lokalNavn;
    private String plassNummer;
    private String pris;
    private String tlfnummer;
    private String dato;
    private String klokkeslett;
    private String arrangementNavn;


    public Billett(String plassNummer, String lokalNavn, String pris, String tlfnummer, String dato, String klokkeslett,
                   String arrangementNavn) {
        this.plassNummer = plassNummer;
        this.lokalNavn=lokalNavn;
        this.pris = pris;
        this.tlfnummer = tlfnummer;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.arrangementNavn= arrangementNavn;
    }
    public void billettSolgt(String format,int index) throws IOException, InvalidFileFormatException{
        FilEndring filEndring;
        if(format.equals("csv")){
            filEndring = new CsvEndring();
        }else{
            filEndring = new JobjEndring();
        }
        filEndring.elementEndrer("arrangement",index);
    }

    @Override
    public String toString() {
        return plassNummer + ";" + lokalNavn + ";" + pris + ";" + tlfnummer + ";" + dato + ";" + klokkeslett
                + ";" + arrangementNavn;
    }

    public String getPlass() {
        return plassNummer;
    }

    public void setPlass(String plass) {
        this.plassNummer = plass;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public String getNummer() {
        return tlfnummer;
    }

    public void setNummer(String nummer) {
        this.tlfnummer = nummer;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getKlokkeslett() {
        return klokkeslett;
    }

    public void setKlokkeslett(String klokkeslett) {
        this.klokkeslett = klokkeslett;
    }
}
