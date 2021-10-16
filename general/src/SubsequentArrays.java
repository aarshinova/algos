//Given two strings str1 and str2, find if str1 is a subsequence of str2.
//        A subsequence is a sequence that can be derived from another sequence by deleting
//        some elements without changing the order of the remaining elements (source: wiki).
//        Expected time complexity is linear.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubsequentArrays {
    public static void main(String[] args) {
        Integer[] tmp = new Integer[]{5, 1, 22, 25, 6, -1, 8, 10};
        List<Integer> arr = Arrays.asList(tmp);
        List<Integer> subsequentArray = Arrays.asList(new Integer[]{1, 6, -1, 10, 11, 11, 11, 11});
        System.out.println("Result : " + isValidSubsequence(arr, subsequentArray));

        List<Integer> arr1 = Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10});
        List<Integer> subsequentArray1 = Arrays.asList(new Integer[]{67});
        System.out.println("Result 1 : " + isValidSubsequence(arr1, subsequentArray1));

        List<Integer> arr2 = Arrays.asList(new Integer[]{1, 1, 1, 1, 1});
        List<Integer> subsequentArray2 = Arrays.asList(new Integer[]{1,1,1});
        System.out.println("Result 2 : " + isValidSubsequence(arr2, subsequentArray2));
    }

    private static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (sequence.size() > array.size()) return false;
        HashMap<Integer, List<Integer>> charPosition = new HashMap<>();
        for (int i = 0; i < array.size(); i++) {
            if (charPosition.containsKey(array.get(i))) {
                List<Integer> positions = charPosition.get(array.get(i));
                positions.add(i);
            } else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                charPosition.put(array.get(i), positions);
            }
        }
        List<Integer> subsqIndexes = new ArrayList<>();
        for (Integer val:sequence){
            if (charPosition.containsKey(val)){
                List<Integer> positions = charPosition.get(val);
                if (positions.size()>0)  {
                    subsqIndexes.add(positions.get(0));
                    positions.remove(0);
                }
                else {
                    return false;
                }
            }else{
                return false;
            }
        }
        int prevValue = subsqIndexes.get(0);
        for (int k=1; k<subsqIndexes.size();k++){
            int currValue = subsqIndexes.get(k);
            if (prevValue>=currValue){
                return false;
            }
            prevValue = currValue;
        }

        return true;
    }
}
