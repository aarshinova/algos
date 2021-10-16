import java.util.*;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] output = smallestDifference(
                new int[] {10, 0, 20, 25, 2200}, new int[] {1005, 1006, 1014, 1032, 1031});
    }

   //  0 10 20 25 2200   n + m
    // 1005 1006 1014 1031 1032

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne); // nlogn + n2
        Arrays.sort(arrayTwo);
        int[] res =new int[2];
        int minVal;

        int j = 0;
        int i = 0;
        int pointer1 = arrayOne[i];
        int pointer2= arrayTwo[j];
        int prevDiff = Math.abs(pointer1-pointer2);
        minVal = prevDiff;

        j = 1;
        while (i<=arrayOne.length-1){
            pointer1 = arrayOne[i]; // 0
            pointer2 = arrayTwo[j]; // 1006
            int diff = Math.abs(pointer1-pointer2); //11
            // save the min
            if (minVal>diff){
                minVal = diff;
                res[0] = pointer1;
                res[1] = pointer2;
            }
            if (diff>prevDiff && j>=1){
                i++;
                j=0;
            }else {
                prevDiff = diff; // 1
                if (j!=arrayTwo.length-1){
                    j++;
                }else {
                    //move i
                    i++;
                }
            }
        }

        return res;
    }
}
