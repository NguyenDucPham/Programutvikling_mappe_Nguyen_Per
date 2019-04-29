package sample;

public class Billett {
    private String lokalNavn;
    private String plassNummer;
    private String pris;
    private String nummer;
    private String dato;
    private String klokkeslett;
    private String arrangementNavn;


    public Billett(String lokalNavn, String plassNummer, String pris, String nummer, String dato, String klokkeslett, String arrangementNavn) {
        this.plassNummer = plassNummer;
        this.lokalNavn=lokalNavn;
        this.pris = pris;
        this.nummer = nummer;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
        this.arrangementNavn= arrangementNavn;
    }

/*

   }*/
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
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
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
