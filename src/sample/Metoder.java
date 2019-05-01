package sample;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Metoder {
    public static String billettTrekker(String[][] DArray, int index){
        String antallBilett = String.valueOf(Integer.parseInt(DArray[index][14])-1);
        return antallBilett;
    }

}
