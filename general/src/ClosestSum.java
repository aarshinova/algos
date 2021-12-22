import java.util.HashMap;
import java.util.HashSet;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
class ClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        Integer minDiff = null;
        Integer closestSum = null;
        HashMap<Integer, Integer> values = new HashMap<>();
        HashSet<Integer> sums = new HashSet<>();

        //-1,2,1,-4
        for (int i = 0; i < nums.length; i++) {
            values.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int val1 = nums[j];
            for (int k = j + 1; k < nums.length; k++) {
                int val2 = nums[k];
                for (int i = k + 1; i < nums.length; i++) {
                    int val3 = nums[i];
                    int sum = val1 + val2 + val3;
                    sums.add(sum);
                }
            }
        }

        for (Integer sum : sums) {
            int diff = Math.abs(target - sum);
            if (minDiff == null) {
                minDiff = diff;
                closestSum = sum;
            } else {
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }
            }
        }

        return closestSum;

    }
}