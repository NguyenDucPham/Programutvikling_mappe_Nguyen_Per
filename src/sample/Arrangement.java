package sample;


public class Arrangement {
     String type;
     String navn;
     String artister;
     String program;
     String tidspunkt;
     double pris;
     String antBilletter;
     String kontaktperson;
     String lokale;
     int []billettArray;
     String []billetter;

    public Arrangement(String kontaktperson,String type, String navn, String artister, String program, String tidspunkt, double pris, String billetter, String lokale) {
        this.type = type;
        this.navn = navn;
        this.artister = artister;
        this.program = program;
        this.tidspunkt = tidspunkt;
        this.pris = pris;
        this.antBilletter = billetter;
        this.kontaktperson = kontaktperson;
        this.lokale = lokale;

    }



    public void lagBillett(int antallBilletter){
        for (int i =0;i<antallBilletter;i++){
            billettArray[i]=i;
        }

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

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getAntBilletter() {
        return antBilletter;
    }

    public void setBilletter(String billetter) {
        this.antBilletter = billetter;
    }
}
