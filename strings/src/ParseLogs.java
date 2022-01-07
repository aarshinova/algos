//You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
//
//There are two types of logs:
//
//Letter-logs: All words (except the identifier) consist of lowercase English letters.
//Digit-logs: All words (except the identifier) consist of digits.
//Reorder these logs so that:
//
//The letter-logs come before all digit-logs.
//The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
//The digit-logs maintain their relative ordering.
//Return the final order of the logs.
import java.util.ArrayList;
import java.util.Collections;

public class ParseLogs {

    public static void main(String[] args) {
    }

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> digits = new ArrayList<>();
        ArrayList<String> letters = new ArrayList<>();
        String[] res = new String[logs.length];

        for (String log : logs){
            if (containsNumbersOnly(log)){
                digits.add(log);
            }else{
                letters.add(log);
            }
        }

        Collections.sort(letters, (st1, st2) -> {
            int ind1 = st1.indexOf(" ");
            int ind2 = st2.indexOf(" ");
            String newSt1 = st1.substring(ind1+1);
            String newSt2 = st2.substring(ind2+1);

            int result = newSt1.compareTo(newSt2);
            if (result!=0){
                return result;
            }
            else {
                return st1.substring(0,ind1).compareTo(st2.substring(0,ind2));
            }
        });

        int i = 0;
        for (String let:letters){
            res[i] = let;
            i++;
        }
        for (String dig:digits){
            res[i] = dig;
            i++;
        }

        return res;
    }

    public static Boolean containsNumbersOnly(String log){
        String[] words = log.split(" ");
        for (int i=1; i<words.length; i++){
            String word = words[i];
            char[] arr = word.toCharArray();
            for (int j=0; j < arr.length; j++){
                if (arr[j]!=' ' && !Character.isDigit(arr[j]))
                {
                    return false;
                }
            }
        }

        return true;
    }
}