import java.util.ArrayList;
import java.util.List;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int rs = kadanesAlgorithm(arr);
        System.out.println("Results is " + rs);
    }

        public static int kadanesAlgorithm(int[] array) {
            int[] max_arr = new int [array.length];

            max_arr[0] = array[0];
            int max = max_arr[0];
            for (int i=1;i<array.length;i++){
                max_arr[i] = Math.max(max_arr[i-1] + array[i], array[i]);
                max = Math.max(max_arr[i], max);
            }
            return max;
        }
    }

