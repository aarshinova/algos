import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Tournament winner
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }

    public static int binarySearch(int[] array, int target) {
        return binarySearchHelper(array, 0, array.length-1, target);
    }

    public static int binarySearchHelper(int [] array, int start, int end, int target){
        int res = -1;
        int mid = (start + end)/2;
        System.out.println("mid "+array[mid]);
        if (target > array[mid] && target<array[end] && (end-mid)>1){
            res = binarySearchHelper(array, mid, end, target);
        }else if (target < array[mid] && target>array[start] && (mid-start)>1){
            res = binarySearchHelper(array, start, mid, target);
        }else {
            if (target==array[mid]){
                return mid;
            }
            else if (target==array[start]){
                return start;
            }
            else if (target==array[end]){
                return end;
            }else {
                return res;
            }
        }

        return res;
    }
}
