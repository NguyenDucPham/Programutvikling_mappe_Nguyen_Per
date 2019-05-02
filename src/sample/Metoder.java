package sample;


public class Metoder {
    public static String[][] billettTrekker(String[][] matrise, int indeks){
        String antallBilett = String.valueOf(Integer.parseInt(matrise[indeks][14])-1);
        matrise[indeks][14] = antallBilett;
        return matrise;
    }

}
