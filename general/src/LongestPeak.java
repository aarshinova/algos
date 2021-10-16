import java.util.*;

public class LongestPeak {
    public static void main(String[] args) {
//        int output = longestPeak(
//                new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3});
//        System.out.println("output " + output);
//        int output2 = longestPeak(
//                new int[] {1, 2, 1});
//        System.out.println("output " + output2);
        int output3 = longestPeak(
                new int[] {1, 1, 3, 2, 1});
        System.out.println("output " + output3);
    }

    //5, 4, 3, 2, 1, 2, 1

    public static int longestPeak(int[] array) {
        if (array.length<3) return 0;

        int maxLength = 0;
        int counter=0;
        boolean incr = false;
        int prevVal = array[0];

        for (int i=0; i < array.length;i++){
            int val = array[i];
            if (counter==0){
                counter++;
            }
            else if (counter==1){
                // non increasing case
                if (val<=prevVal){
                    counter = 0;
                    i = i - 1;
                    continue;
                }
                incr = true;
                counter++;
            }
            else if (counter>=2) {
                if (prevVal>val && incr){
                    //edge case
                    if (i==array.length-1){
                        maxLength = Math.max(maxLength,counter+1);
                    }
                    incr = false;
                    counter++;
                }
                else if (val>prevVal && incr){
                    counter++;
                }
                else if (prevVal>val && !incr){
                    //edge case
                    if (i==array.length-1){
                        maxLength = Math.max(maxLength,counter+1);
                    }
                    counter++;
                }
                else if (val>prevVal && !incr){
                    maxLength = Math.max(maxLength,counter);
                    counter=0;
                    i = i - 2;
                }
                else if (val==prevVal && !incr){
                    maxLength = Math.max(maxLength,counter);
                    counter=0;
                    i = i - 1;
                }
                else {
                    counter=0;
                    i = i - 1;
                }
            }
            prevVal = val;
        }


        return maxLength;
    }
}
