import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.

public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;
        int[] res = find2Sum(array, target);
        if (res.length>0)
        System.out.println("Result 2 sum : " + res[0] + " and " + res[1]);
        else
            System.out.println("Result is empty " );
    }

    private static int[] find2Sum(int[] array, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> tempBucket = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int diff = target - array[i];
            if (tempBucket.containsKey(diff)){
                result[0] = array[i];
                result[1] = diff;
                return  result;
            }else {
                tempBucket.put(array[i], i);
            }
        }
        return new int[]{};
    }
}