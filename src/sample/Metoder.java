package sample;


public class Metoder {
    public static String[][] billettTrekker(String[][] matrise, int indeks){
        //System.out.println(matrise);
        String antallBilett = matrise[indeks][14];
        int tallBillett = Integer.parseInt(antallBilett) - 1;
        System.out.println(tallBillett);
        antallBilett = String.valueOf(tallBillett);
        matrise[indeks][14] = antallBilett;
        return matrise;
    }

}
