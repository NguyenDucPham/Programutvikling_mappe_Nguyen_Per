package sample;


public class Metoder {
    public static String[][] billettTrekker(String[][] matrise, int indeks){
        try {
            System.out.println(matrise[indeks][14] + "ok det er meg");
        }catch (Exception e){
            System.out.println("faeil dlfasdfksjføksal");
        }
        String antallBilett = String.valueOf(matrise[indeks][14]);
        int tallBillett = Integer.parseInt(antallBilett) - 1;
        System.out.println(tallBillett);
        antallBilett = String.valueOf(tallBillett);
        matrise[indeks][14] = antallBilett;
        return matrise;
    }

}
