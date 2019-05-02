package sample;

public class Tabell {

    private String navn;
    private String lokaleType;
    private String pris;
    private String tidspunkt;

    public Tabell(String navn, String lokaleType, String pris, String tidspunkt){
        this.navn = navn;
        this.lokaleType = lokaleType;
        this.pris = pris;
        this.tidspunkt = tidspunkt;

    }

    @Override
    public String toString() {
        return navn + ";" + lokaleType + ";" + pris + ";" + tidspunkt;
    }
}
