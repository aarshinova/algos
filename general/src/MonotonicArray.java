import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonotonicArray {
    public static void main(String[] args) {
        var array = new int[]{1,2,0};
        System.out.println(isMonotonic(array));
    }

    public static boolean isMonotonic(int[] array) {
        boolean isIncreasing = false;
        boolean isMonotonic = true;
        boolean isTrendSet = false;

        if (array.length <= 2)
            return true;

        int prev = array[0];
        for (int i = 1; i < array.length; i++) {
            if (!isTrendSet) {
                if (array[i] > prev) {
                    isIncreasing = true;
                    isTrendSet = true;
                } else if (array[i] < prev) {
                    isIncreasing = false;
                    isTrendSet = true;
                }
            } else if (isTrendSet) {
                if (isIncreasing) {
                    if (array[i] < prev) {
                        isMonotonic = false;
                    }
                } else if (isIncreasing == false) {
                    if (array[i] > prev) {
                        isMonotonic = false;
                    }
                }
            }
            prev = array[i];
        }
        return isMonotonic;
    }
}
