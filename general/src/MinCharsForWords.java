import java.util.ArrayList;
import java.util.HashMap;

public class MinCharsForWords {
    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] res = minimumCharactersForWords(words);
        System.out.println("Result : " + res);
    }

    public static char[] minimumCharactersForWords(String[] words) {
        if (words.length==0) return new char[]{};
        ArrayList<Character> minArr = new ArrayList<>();
        String word = words[0];
        for (int i=0; i<word.length(); i++){
            minArr.add(word.charAt(i));
        }

        for (int j=1; j<words.length; j++){
            String curr = words[j];
            ArrayList<Character> copyOfMinArr = new ArrayList<>(minArr);
            for (int k=0; k<curr.length(); k++){
                char ch = curr.charAt(k);
                if (copyOfMinArr.contains((Character) ch)){
                    copyOfMinArr.remove((Character) ch);
                }else {
                    minArr.add(ch);
                }
            }

        }
        char[] res = new char[minArr.size()];
        for (int count = 0 ; count<res.length; count++){
            res[count] = minArr.get(count);
        }

        return res;
    }
}
