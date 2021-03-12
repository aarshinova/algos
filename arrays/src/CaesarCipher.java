import java.util.HashMap;

// Tournament winner
public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc", 52));
    }
    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder st = new StringBuilder();
        char[] arr = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q', 'r', 's','t', 'u', 'v', 'w','x','y','z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q', 'r', 's','t', 'u', 'v', 'w','x','y','z'};
        HashMap<Character,Integer> dict = new HashMap<>();
       for (int i=0; i<arr.length/2;i++){
           dict.put(arr[i],i);
       }

       int newKey = key%26;
       char[] word = str.toCharArray();
       for (int idx=0; idx<word.length; idx++){
           Integer charToDecodeIdx = dict.get(word[idx]);
           st.append(arr[charToDecodeIdx+newKey]);
       }

        return st.toString();
    }
}
