package sample;

import java.io.Serializable;

public class KontaktPerson implements Serializable {
    private static final long serialVersionUID = 2;

    private String Navn;
    private String TelefonNummer;
    private String Email;
    private String Ekstraopplysning;
    private String Nettside;
    private String Firma;

    public KontaktPerson(String navn, String telefonNummer, String email, String ekstraopplysning, String nettside, String firma) {
        Navn = navn;
        TelefonNummer = telefonNummer;
        Email = email;
        Ekstraopplysning = ekstraopplysning;
        Nettside = nettside;
        Firma = firma;
    }

    public String getNavn() {
        return Navn;
    }

    public void setNavn(String navn) {
        Navn = navn;
    }

    public String getTelefonNummer() {
        return TelefonNummer;
    }

    public void setTelefonNummer(String telefonNummer) {
        TelefonNummer = telefonNummer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEkstraopplysning() {
        return Ekstraopplysning;
    }

    public void setEkstraopplysning(String ekstraopplysning) {
        Ekstraopplysning = ekstraopplysning;
    }

    public String getNettside() {
        return Nettside;
    }

    public void setNettside(String nettside) {
        Nettside = nettside;
    }

    public String getFirma() {
        return Firma;
    }

    public void setFirma(String firma) {
        Firma = firma;
    }



}
