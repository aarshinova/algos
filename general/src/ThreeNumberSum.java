import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i=0; i<array.length; i++){
            int val = array[i];
            int twoSumTarget = targetSum - val;
            List<Integer[]> twoSumResult = twoSum(i+1, array, twoSumTarget);
            for (int k=twoSumResult.size()-1; k>=0; k--){
                Integer[] twoSumRes = twoSumResult.get(k);
                Integer[] newRes = new Integer[]{val, twoSumRes[0], twoSumRes[1]};
                result.add(newRes);
            }
        }
        return result;
    }

    public static List<Integer[]> twoSum(int posToStart, int[] array, int targetSum){
        Set<Integer> sumSet = new HashSet<>();
        List<Integer[]> result = new ArrayList<>();
        for (int j = posToStart; j < array.length; j++) {
            int val = array[j];
            if (sumSet.contains(targetSum - val)) {
                result.add(new Integer[]{targetSum - val,val});
            } else {
                sumSet.add(val);
            }
        }
        return result;
    }
}
