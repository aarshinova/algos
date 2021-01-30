// Description
//Caesar Cipher Encrpytion
//Caesar Cipher Encrpytion
//      You are given a list of string, group them if they are same after using Ceaser Cipher Encrpytion.
//    Definition of "same", "abc" can right shift 1, get "bcd", here you can shift as many time as you want, the string will be considered as same.
// basically group strings if there are crypted by cipher with any key
// Input ["abc", "bcd", "acd", "dfg"]
// Output [["abc", "bcd"], ["acd", "dfg"]]

import java.util.*;
import java.util.function.Predicate;

public class CaesarCipherGrouped {

    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acd", "dfg"};
        String[][] res = {{"abc", "bcd"}, {"acd", "dfg"}};
        System.out.println("Result " + encodeTest(input, res));
    }

    private static String[][] caesarCipherGrouped(String[] array) {
        int[][] helperArray = new int[array.length][100];
        // outcome "97,98,99" "98,99,100" "99,100,110" "110,100,112"
        int i = 0;
        for (String item : array) {
            char[] tmpArr = item.toCharArray();
            int k = 0;
            for (char ch : tmpArr) {
                helperArray[i][k] = (int) ch;
                k++;
            }
            i++;
        }
        // outcome [ [bcd,bcd], [,]]
        int j, k, l = 0;
        String[][] tmpResult = new String[array.length][2];
        for (j = 0; j < helperArray.length; j++) {
            int[] val1 = helperArray[j];
            for (k = j + 1; k < helperArray.length; k++) {
                int[] val2 = helperArray[k];
                int prevDiff,currDiff = 0;
                if (val1.length!=val2.length) continue;
                prevDiff = val1[0] - val2[0];
                int x=0;
                boolean same = true;
                while (x<val1.length){
                    if (val1[x]==0) break;
                    currDiff = val1[x] - val2[x];
                    if (currDiff!=prevDiff) {
                        same = false;
                        break;
                    }
                    prevDiff = currDiff;
                    x++;
                }
                if (same) {
                    tmpResult[l][0] = array[j];
                    tmpResult[l][1] = array[k];
                    l++;
                }
            }
        }

        List<String[]> list = new ArrayList<>();
        for (String[] s : tmpResult) {
            if (s != null && s.length > 0) {
                list.add(s);
            }
        }

        return list.toArray(new String[list.size()][2]);
    }

    private static boolean encodeTest(String[] input, String[][] expectedRes) {
        String[][] result = caesarCipherGrouped(input);
        for (int i = 0; i < expectedRes.length; i++) {
            for (int j = 0; j < expectedRes.length; j++) {
                if (expectedRes[i][j] != result[i][j])
                    return false;
            }
        }
        return true;
    }
}