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
    private String antallPlasser;
    private String antallLedigeBilletter;


    public Arrangement(String kontaktperson, String kontaktTelefon, String epost, String nettSide, String firma,
                       String opplysninger, String navn, String artister, String program, String tidspunkt, String pris,
                       String lokale, String lokalType, String antallPlasser, String antallLedigeBilletter) {
        this.navn = navn;
        this.artister = artister;
        this.program = program;
        this.tidspunkt = tidspunkt;
        this.pris = pris;
        this.kontaktperson = kontaktperson;
        this.kontaktTelefon = kontaktTelefon;
        this.epost = epost;
        this.opplysninger = opplysninger;
        this.nettSide = nettSide;
        this.firma = firma;
        this.lokale = lokale;
        this.lokalType = lokalType;
        this.antallPlasser = antallPlasser;
        this.antallLedigeBilletter=antallLedigeBilletter;
    }

  /*  public void lagBillett(int antallSeter, String ArrangementNavn) {
        for (int i = 0; i < antallSeter; i++) {
            String enbillett = ArrangementNavn + (i);
            billettArray[i] = enbillett;
        }
    }*/

    @Override
    public String toString() {
        return navn + ";" + artister + ";" + program + ";" + tidspunkt + ";" + pris + kontaktperson + ";"
                + kontaktTelefon + ";" + epost + ";" + opplysninger + ";" + nettSide + ";" + firma + ";" + lokale + ";"
                + lokalType + ";" + antallPlasser + ";" + antallLedigeBilletter;
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

    public String getKontaktperson() {
        return kontaktperson;
    }

    public void setKontaktperson(String kontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getNettSide() {
        return nettSide;
    }

    public void setNettSide(String nettSide) {
        this.nettSide = nettSide;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getOpplysninger() {
        return opplysninger;
    }

    public void setOpplysninger(String opplysninger) {
        this.opplysninger = opplysninger;
    }

    public String getLokale() {
        return lokale;
    }

    public void setLokale(String lokale) {
        this.lokale = lokale;
    }

    public String getLokalType() {
        return lokalType;
    }

    public void setLokalType(String lokalType) {
        this.lokalType = lokalType;
    }

    public String getAntallPlasser() {
        return antallPlasser;
    }

    public void setAntallPlasser(String antallPlasser) {
        this.antallPlasser = antallPlasser;
    }
}
