package sample;

public class Splittere {
    public static String[] linjeSplitter(String string){
        try{
            String[] object = string.split("\n");

            return object;
        }catch(Exception e){

        } return null;
    }

    public static String[][] objectSplitter(String[] object){
        try {
            String[] antElement = object[0].split(";");
            String[][] element = new String[object.length][antElement.length];
            for (int i = 0; i < object.length; i++) {
                antElement = object[i].split(";");
                for (int j = 0; j < antElement.length; j++) {
                    element[i][j] = antElement[j];
                }
            }

            return element;
        }catch(Exception e) {

        }return null;

    }
}
