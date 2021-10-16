import java.util.*;

public class LongestAnagrams {
    public static void main(String[] args) {
        List<String> words =
                new ArrayList<>(
                        Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"));
        System.out.println("Longest " + groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<Integer>> anagramsMap = new HashMap<>();
        List<List<String>> anagramGroupped = new ArrayList<>();

        int ind = 0;
        for (String word : words){
            char[] anagr = word.toCharArray();
            Arrays.sort(anagr);
            String result = String.copyValueOf(anagr);
            if (anagramsMap.containsKey(result)){
                List<Integer> indexes = anagramsMap.get(result);
                indexes.add(ind);
                anagramsMap.put(result, indexes);
            }else{
                System.out.println("new " + ind);
                List<Integer> indexes = new ArrayList<>();
                indexes.add(ind);
                anagramsMap.put(result,indexes);
            }
            ind++;
        }

        for (Map.Entry<String, List<Integer>> entry : anagramsMap.entrySet()){
            List<String> list = new ArrayList<>();
            for (Integer i : entry.getValue()){
                list.add(words.get(i));
            }
            anagramGroupped.add(list);
        }

        return anagramGroupped;

    }


}
