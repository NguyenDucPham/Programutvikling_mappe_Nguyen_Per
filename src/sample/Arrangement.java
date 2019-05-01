package sample;


import java.io.Serializable;

public class Arrangement implements Serializable {
    private static final long serialVersionUID = 2;

    private String type;
    private String navn;
    private String artister;
    private String program;
    private String tidspunkt;
    private String pris;
    private int antBilletter;
    private String kontaktperson;
    private String kontaktTelefon;
    private String epost;
    private String nettSide;
    private String firma;
    private String opplysninger;
    private String lokale;
    private String lokalType;
    private int antallPlasser;
    private int antallLedigeBilletter;


    public Arrangement(String kontaktperson, String kontaktTelefon, String epost, String nettSide, String firma,
                       String opplysninger, String type, String navn, String artister, String program,
                       String tidspunkt, String pris, int antBilletter, String lokale, String lokalType, int antallPlasser) {
        this.type = type;
        this.navn = navn;
        this.artister = artister;
        this.program = program;
        this.tidspunkt = tidspunkt;
        this.pris = pris;
        this.antBilletter = antBilletter;
        this.kontaktperson = kontaktperson;
        this.kontaktTelefon = kontaktTelefon;
        this.epost = epost;
        this.nettSide = nettSide;
        this.firma = firma;
        this.opplysninger = opplysninger;
        this.lokale = lokale;
        this.lokalType = lokalType;
        this.antallPlasser = antallPlasser;
        this.antallLedigeBilletter=antBilletter;
    }

  /*  public void lagBillett(int antallSeter, String ArrangementNavn) {
        for (int i = 0; i < antallSeter; i++) {
            String enbillett = ArrangementNavn + (i);
            billettArray[i] = enbillett;
        }
    }*/

    @Override
    public String toString() {
        return type + ";" + navn + ";" + artister + ";" + program + ";" + tidspunkt + ";" + pris + ";" + antBilletter
                + ";" + kontaktperson + ";" + lokale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getArtister() {
        return artister;
    }

    public void setArtister(String artister) {
        this.artister = artister;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getPris() {
        return pris;
    }

    public void setPris(String pris) {
        this.pris = pris;
    }

    public int getAntBilletter() {
        return antBilletter;
    }

    public void setBilletter(int billetter) {
        this.antBilletter = billetter;
    }
}
