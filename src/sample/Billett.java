package sample;

public class Billett {
    String plass;
    String pris;
    String nummer;
    String dato;
    String klokkeslett;

    public Billett(String plass, String pris, String nummer, String dato, String klokkeslett) {
        this.plass = plass;
        this.pris = pris;
        this.nummer = nummer;
        this.dato = dato;
        this.klokkeslett = klokkeslett;
    }

    public String getPlass() {
        return plass;
    }

    public void setPlass(String plass) {
        this.plass = plass;
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
