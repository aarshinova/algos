import java.util.*;

class SearchForRange {
    static int minInd;
    static int maxInd;
    public static int[] searchForRange(int[] array, int target) {
        minInd = -1;
        maxInd = -1;
        binarySearchHelper(0, array.length-1, array, target);
        return new int[]{minInd,maxInd};
    }

    public static void binarySearchHelper(int left, int right, int[] array, int target){
        if (left>right){
            return;
        }

        int mid = (left+right)/2;

        if (array[mid]==target){
            // min and max determination
            setMinAndMax(array, mid);
            // modified bs
            // left side
            if ((mid-1)>0){
                binarySearchHelper(left, mid - 1, array, target);
            }
            // right side
            if ((mid+1)<array.length ){
                binarySearchHelper(mid + 1, right, array, target);
            }
        }
        else if (target < array[mid]){
            binarySearchHelper(left, mid-1, array, target);
        }
        else if (target > array[mid]){
            binarySearchHelper(mid + 1, right, array, target);
        }
    }

    public static void setMinAndMax(int[] array, int mid){
        if (minInd < 0){
            minInd = mid;
        }else {
            minInd = Math.min(minInd, mid);
        }
        if (maxInd < 0){
            maxInd = mid;
        }else {
            maxInd = Math.max(maxInd, mid);
        }
    }
}
