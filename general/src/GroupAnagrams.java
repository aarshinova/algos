import java.util.*;
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
class GroupAnagrams {
    // n * mlogm  n
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagMap = new HashMap<>();

        for (String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key =Arrays.toString(arr);
            if (anagMap.containsKey(key)){
                List<String> anagrams = anagMap.get(key);
                anagrams.add(str);
                anagMap.put(key, anagrams);
            }else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                anagMap.put(key, anagrams);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagMap.entrySet() ){
            res.add(entry.getValue());
        }

        return res;

    }
}