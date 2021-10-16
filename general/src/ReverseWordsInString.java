import java.util.*;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println("Result : " + reverseWordsInString("AlgoExpert is the best!"));
    }

    public static String reverseWordsInString(String string) {
        char emptyChar = ' ';
        String word = "";
        ArrayList<String> allWords = new ArrayList<>();
        for (int i=0; i<string.length();i++){
            char curr = string.charAt(i);
            if (i>0 && string.charAt(i-1)!=emptyChar && curr==emptyChar){
                allWords.add(word);
                word = " ";
            }else if (i>0 && string.charAt(i-1)==emptyChar && curr==emptyChar){
                word += " ";
            }else if (i>0 && string.charAt(i-1)==emptyChar && curr!=emptyChar){
                allWords.add(word);
                word = "";
                word += curr;
            }
            else {
                word += curr;
            }

            if (i==string.length()-1){
                allWords.add(word);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int j=allWords.size()-1; j>=0; j--){
            result.append(allWords.get(j));
        }
        return result.toString();
    }
}
