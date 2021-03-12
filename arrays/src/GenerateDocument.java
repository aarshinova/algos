import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        boolean res = generateDocument(characters, document);
        if (expected!=res){
            System.out.println("Failed!");
        }else{
            System.out.println("Success!");
        }
    }

    public static boolean generateDocument(String characters, String document) {
        char[] charArr = characters.toCharArray();
        char[] documentArr = document.toCharArray();
        HashMap<Character, Integer> charDict = new HashMap<>();
        HashMap<Character, Integer> docDict = new HashMap<>();

        for (int i = 0; i < charArr.length; i++) {
            if (charDict.containsKey(charArr[i])) {
                int val =  charDict.get(charArr[i]);
                charDict.put(charArr[i], val+1);
            }
            else
                charDict.put(charArr[i], 1);
        }

        for (int i = 0; i < documentArr.length; i++) {
            if (docDict.containsKey(documentArr[i])) {
                int val =  docDict.get(documentArr[i]);
                docDict.put(documentArr[i], val+1);
            }
            else
                docDict.put(documentArr[i], 1);
        }

        for (Map.Entry<Character, Integer> el : docDict.entrySet()) {
            Character docKey = el.getKey();
            if (charDict.containsKey(docKey)) {
                Integer docValue = el.getValue();
                if (charDict.get(docKey) < docValue) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
