package sample;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Metoder {
    public static String[][] billettTrekker(String[][] dArray, int index){
        String antallBilett = String.valueOf(Integer.parseInt(dArray[index][14])-1);
        dArray[index][14] = antallBilett;
        return dArray;
    }

}
