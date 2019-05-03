package sample;


import java.io.Serializable;

public class Arrangement implements Serializable {
    private static final long serialVersionUID = 2;

    private String navn;
    private String artister;
    private String program;
    private String tidspunkt;
    private String pris;
    private String kontaktPerson;
    private String kontaktTelefon;
    private String ePost;
    private String nettSide;
    private String firma;
    private String opplysninger;
    private String lokale;
    private String lokaleType;
    private String antallPlasser;
    private String antallLedigeBilletter;


    public Arrangement(String navn, String lokaleType, String pris, String tidspunkt){
        this.navn = navn;
        this.lokaleType = lokaleType;
        this.pris = pris;
        this.tidspunkt = tidspunkt;

    }

    public Arrangement(String navn, String artister, String program, String tidspunkt, String pris,
                       String kontaktPerson, String kontaktTelefon, String ePost, String opplysninger, String nettSide,
                       String firma, String lokale, String lokaleType, String antallPlasser, String antallLedigeBilletter) {
        this.navn = navn;
        this.artister = artister;
        this.program = program;
        this.tidspunkt = tidspunkt;
        this.pris = pris;
        this.kontaktPerson = kontaktPerson;
        this.kontaktTelefon = kontaktTelefon;
        this.ePost = ePost;
        this.opplysninger = opplysninger;
        this.nettSide = nettSide;
        this.firma = firma;
        this.lokale = lokale;
        this.lokaleType = lokaleType;
        this.antallPlasser = antallPlasser;
        this.antallLedigeBilletter=antallLedigeBilletter;
    }

    @Override
    public String toString() {
        return navn + ";" + artister + ";" + program + ";" + tidspunkt + ";" + pris + ";" + kontaktPerson + ";"
                + kontaktTelefon + ";" + ePost + ";" + opplysninger + ";" + nettSide + ";" + firma + ";" + lokale + ";"
                + lokaleType + ";" + antallPlasser + ";" + antallLedigeBilletter;
    }

    public void setAntallLedigeBilletter(String antallLedigeBilletter) {
        this.antallLedigeBilletter = antallLedigeBilletter;
    }

    public String getAntallLedigeBilletter() {
        return antallLedigeBilletter;
    }
}
