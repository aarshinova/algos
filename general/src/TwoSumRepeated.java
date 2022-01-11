import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Numbers can repeat
 */
class   TwoSumRepeated {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer[]> numsMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            if (numsMap.containsKey(nums[i])){
                Integer[] values = numsMap.get(nums[i]);
                Integer[] valArr = new Integer[values.length+1];
                int j=0;
                for (int val:values){
                    valArr[j] = val;
                    j++;
                }
                valArr[values.length] = i;
                numsMap.put(nums[i], valArr);
            }else {
                numsMap.put(nums[i], new Integer[]{i});
            }
        }

        for (Map.Entry<Integer, Integer[]> val : numsMap.entrySet()){
            int num1 = val.getKey();
            int num2 = target - num1;
            int ind1 = val.getValue()[0];
            if (num1==num2 && val.getValue().length>1){
                return new int[]{ind1, val.getValue()[1]};
            }
            else if (numsMap.containsKey(num2)){
                Integer[] secondInds = numsMap.get(num2);
                return new int[]{ind1, secondInds[0]};

            }
        }
        return new int[]{};
    }
}