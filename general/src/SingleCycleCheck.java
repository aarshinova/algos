import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SingleCycleCheck {
    public static void main(String[] args) {
       int[] array1 =  new int[] {2, 3, 1, -4, -4, 2};
       int[] array2 =  new int[] {2, 2, -1};
       int[] array3 =  new int[] {1, -1, 1, -1};
       int[] array4 =  new int[] {1, 1, 0, 1, 1};
       int[] array5 =  new int[] {1, 1, 1, 1, 2};
        System.out.println(" The result is " + hasSingleCycle(array5));
    }

    public static boolean hasSingleCycle(int[] array) {
        int arrLength = array.length;
        int numberVisited = 1;
        int currentIndex = 0;

        while (currentIndex<arrLength){
            int jumpValue = array[currentIndex];
            int nextIndex = returnNextIndex(jumpValue, currentIndex, arrLength);
            currentIndex = nextIndex;
            if (currentIndex==0 || jumpValue==0 || numberVisited>arrLength){
                break;
            }
            numberVisited ++;
        }

        return (currentIndex==0 && numberVisited==arrLength);
    }

    public static int returnNextIndex(int jumpValue, int i, int arrLength){
        int res = Math.abs(i+jumpValue);
        int offset;
        int resIndex;
        if (res<= arrLength){
            offset = (res == arrLength)? 0 : res;
        }else {
            offset = res % arrLength;
        }
        resIndex = (jumpValue<0 && offset!=0 && Math.abs(jumpValue)>i) ? arrLength - offset : offset;
        return resIndex;
    }
}

