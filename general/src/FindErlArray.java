import java.util.*;

public class FindErlArray {
    public static void main(String[] args) {
        int[][] encoded1 = new int[5][2];
        //encoded1[0] = new int[]{1, 3};
       // encoded1[1] = new int[]{2, 3};
        encoded1[0] = new int[]{1, 1};
        encoded1[1] = new int[]{2,1};
        encoded1[2] = new int[]{1,1};
        encoded1[3] = new int[]{2,1};
        encoded1[4] = new int[]{1,1};
        int[][] encoded2 = new int[5][2];
       // encoded2[0] = new int[]{6, 3};
        //encoded2[1] = new int[]{3, 3};
        encoded2[0] = new int[]{1, 1};
        encoded2[1] = new int[]{2,1};
        encoded2[2] = new int[]{1,1};
        encoded2[3] = new int[]{2,1};
        encoded2[4] = new int[]{1,1};
        int[][] rs = findErlArray(encoded1, encoded2);
        System.out.println("Results is " + rs);
    }

    public static int[][] findErlArray(int[][] encoded1, int[][] encoded2) {
       ArrayList<Integer> decodedArray1 = decodeArray(encoded1);
        ArrayList<Integer> decodedArray2 = decodeArray(encoded2);
       int[] productArr = new int[decodedArray1.size()];
       for (int i=0;i <decodedArray1.size(); i++) {
           productArr[i] = decodedArray1.get(i)*decodedArray2.get(i);
       }
        List<List<Integer>> encodedPrArr = new ArrayList<>();

       int mem = productArr[0];
       int count = 1;
       for (int j=1; j<productArr.length; j++){
           if (productArr[j]!=mem){
               ArrayList<Integer> newVal = new ArrayList<>();
               newVal.add(mem);
               newVal.add(count);
               encodedPrArr.add(newVal);
               count = 1;
           }
           else {
               count ++;
           }
           mem = productArr[j];
       }

        if (mem==productArr[productArr.length-1]){
            ArrayList<Integer> newVal = new ArrayList<>();
            newVal.add(mem);
            newVal.add(count);
            encodedPrArr.add(newVal);
        }

       int result [][] = new int[encodedPrArr.size()][2];
       for (int k=0; k < encodedPrArr.size();k++){
           result[k][0] = encodedPrArr.get(k).get(0);
           result[k][1] = encodedPrArr.get(k).get(1);
       }

       return result;
    }

    public static ArrayList<Integer> decodeArray(int[][] encoded){
        ArrayList<Integer> encodedArr = new ArrayList<>();
        for (int i = 0; i<encoded.length;i++){
            int value =   encoded[i][0];
            int number = encoded[i][1];
            for (int tmp=1; tmp<=number;tmp++){
                encodedArr.add(value);
            }
        }
        String string = "";

        return encodedArr;
    }



}
