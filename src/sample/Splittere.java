package sample;

public class Splittere {
    public static String[] linjeSplitter(String streng){
        String[] objekt = streng.split("\n");
        return objekt;
    }

    public static String[][] objectSplitter(String[] object){
        String[] antElement = object[0].split(";");
        String[][] element = new String[object.length][antElement.length];
        for (int i = 0; i < object.length; i++) {
            antElement = object[i].split(";");
            for (int j = 0; j < antElement.length; j++) {
                element[i][j] = antElement[j];
            }
        }
        return element;

    }
}
