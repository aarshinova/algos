//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//

import java.util.Arrays;

public class ArrayProduct {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            //[3  4  5  1]
            // -  3  12  60
            // 20 5  1   -

            int[] arr = new int[nums.length];
            Arrays.fill(arr, 1);

            int prod1 = 1;
            for (int i=0; i<nums.length; i++){
                if (i!=0){
                    prod1 *=nums[i-1];
                    arr[i] = prod1;
                }
            }

            int prod2 = 1;
            for (int j=nums.length-1; j>=0; j--){
                if (j!=nums.length-1){
                    prod2 *= nums[j+1];
                    arr[j] *= prod2;
                }
            }

            return arr;
        }

    }


}
