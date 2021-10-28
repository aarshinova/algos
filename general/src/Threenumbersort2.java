import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Threenumbersort2 {
    public static HashMap<String, ArrayList<String>> dict = new HashMap<>();

    public static void main(String[] args) {
        var array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[]{0, 1, -1};
        var res = threeNumberSort(array, order);
        for (int i=0;i<res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

    // 1 0 0 -1 -1 0 1 1
    // 0 1 0 -1 -1 0 1 1
    // 0 0 1 -1 -1 0 1 1
    // 0 0 0 -1 -1 1 1 1

    public static int[] threeNumberSort(int[] array, int[] order) {
        int firstVal = order[0];
        for (int i=0;i<array.length; i++){
            if (array[i]!=firstVal){
                int j = i + 1;
                while (j<array.length){
                    if (array[j]==firstVal){
                        swap(i, j, array);
                    }
                    j++;
                }
            }
        }

        int lastVal = order[2];
        for (int i=array.length-1;i>=0; i--){
            if (array[i]!=lastVal){
                int j = i - 1;
                while (j>=0){
                    if (array[j]==lastVal){
                        swap(i, j, array);
                    }
                    j--;
                }
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
