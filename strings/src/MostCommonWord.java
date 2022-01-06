//Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
// It is guaranteed there is at least one word that is not banned, and that the answer is unique.
//
//The words in paragraph are case-insensitive and the answer should be returned in lowercase.
import java.util.Arrays;
import java.util.HashSet;

public class MostCommonWord {

    public static void main(String[] args) {
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String mostCommon = "";
        Integer maxCount = 0;

        HashSet<String> bannedSet = new HashSet<>();
        for (String st:banned){
            bannedSet.add(st);
        }

        paragraph=paragraph.replace("!"," ");
        paragraph=paragraph.replace("?"," ");
        paragraph=paragraph.replace(","," ");
        paragraph=paragraph.replace(","," ");
        paragraph=paragraph.replace(";"," ");
        paragraph=paragraph.replace("."," ");
        paragraph=paragraph.replace("'"," ");
        paragraph = paragraph.toLowerCase();

        String[] words = paragraph.split(" ");
        Arrays.sort(words);

        String word = words[0];
        int count = 1;
        for (int i=1; i<words.length; i++){
            String currWord = words[i];
            if (currWord.compareTo(word)!=0){
                if (count > maxCount && !bannedSet.contains(word) && word.compareTo("")!=0){
                    maxCount = count;
                    mostCommon = word;
                }
                word = currWord;
                count = 1;
            }else{
                count++;
            }
        }

        if (count > maxCount && !bannedSet.contains(word) && word.compareTo("")!=0){
            mostCommon = word;
        }

        return mostCommon;
    }
}