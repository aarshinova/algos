//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
public class MissingNumber {
    public static void main(String[] args) {

    }

    class Solution {
        public int missingNumber(int[] nums) {
            // Another solution
            // int[] arr = new int[nums.length+1];
            // for (int i=0; i<nums.length; i++){
            //     int pos = nums[i];
            //     arr[pos] = 1;
            // }
            // for (int j=0; j<arr.length; j++){
            //     if (arr[j]==0){
            //         return j;
            //     }
            // }

            int sum = 0;
            int sumInd = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                sumInd += i;
            }

            sumInd += len;

            return (sumInd - sum);
        }
    }

}
