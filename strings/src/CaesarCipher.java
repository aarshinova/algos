// Description
//Caesar Cipher Encrpytion
// You are given a list of string, group them if they are same after using Ceaser Cipher Encrpytion.
// Definition of "same", "abc" can right shift 1, get "bcd", here you can shift as many time as you want, the string will be considered as same.


import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {

    public static void main(String[] args) {
        encodeTest("ATTACKATONCE", 4, "EXXEGOEXSRGI");
        encodeTest("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 23, "XYZABCDEFGHIJKLMNOPQRSTUVW");
    }

    private static String caesarCipher(Integer key, String word) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        Map<Character, Character> dict = new HashMap<>();

        char[] arr = alphabet.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i >= key) {
                dict.put(arr[i - key], arr[i]);
            }
        }

        char[] wordToEncode = word.toLowerCase().toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int k = 0; k < wordToEncode.length; k++) {
            buffer.append(dict.get(wordToEncode[k]));
        }
        return buffer.toString();
    }

    private static void encodeTest(String word, Integer key, String expResult) {
        String result = caesarCipher(key, word);
        System.out.println(result.equalsIgnoreCase(expResult.toLowerCase()));
    }
}