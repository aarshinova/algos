import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

class Threenumbersort {
    public static HashMap<String, ArrayList<String>> dict = new HashMap<>();

    public static void main(String[] args) {
        var array = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[]{0, 1, -1};
        var res = threeNumberSort(array, order);
        System.out.println("Result " + res);
    }

    public static int[] threeNumberSort(int[] array, int[] order) {
        HashMap<Integer, Integer> counts = new LinkedHashMap<>();
        for (int i = 0; i < order.length; i++) {
            counts.put(order[i], 0);
        }
        for (int i = 0; i < array.length; i++) {
            int count = counts.get(array[i]) + 1;
            counts.put(array[i], count);
        }
        Integer val1 = counts.get(order[0]);
        Integer val2 = counts.get(order[1]);
        Integer val3 = counts.get(order[2]);
        Integer counter1 = 0, counter2 = 0, counter3 = 0;
        for (int j = 0; j < array.length; j++) {
            if (val1 != null) {
                if (counter1 == val1) {
                    j--;
                    val1 = null;
                    continue;
                }
                array[j] = order[0];
                counter1++;
            } else if (val2 != null) {
                if (counter2 == val2) {
                    j--;
                    val2 = null;
                    continue;
                }
                array[j] = order[1];
                counter2++;
            } else if (val3 != null) {
                if (counter3 == val3) {
                    j--;
                    val3 = null;
                    continue;
                }
                array[j] = order[2];
                counter3++;
            }
        }
        return array;
    }
}
