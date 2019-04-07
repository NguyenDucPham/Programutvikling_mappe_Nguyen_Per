package sample;

public class Lokale {

    private String LokalNavn;
    //skal være kino, konsertsal, foredragssal, teatersal
    private String LokalType;
    private int AntallPlasser;


    public String getLokalNavn() {
        return LokalNavn;
    }

    public void setLokalNavn(String lokalNavn) {
        LokalNavn = lokalNavn;
    }

    public String getLokalType() {
        return LokalType;
    }

    public void setLokalType(String lokalType) {
        LokalType = lokalType;
    }

    public int getAntallPlasser() {
        return AntallPlasser;
    }

    public void setAntallPlasser(int antallPlasser) {
        AntallPlasser = antallPlasser;
    }



}
