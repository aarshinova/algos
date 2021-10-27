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
        //init
        for (int i = 0; i < order.length; i++) {
            counts.put(order[i], 0);
        }
        for (int i = 0; i < array.length; i++) {
            int count = counts.get(array[i]) + 1 ;
            counts.put(array[i], count);
        }

        Integer val1 = counts.get(order[0]);
        Integer val2 = counts.get(order[1]);
        Integer val3 = counts.get(order[2]);
        Integer counter1 = 0, counter2=0, counter3=0;
        for (int j=0;j<array.length;j++){
           if (val1!=null){
               if (counter1==val1) {
                   j--;
                   val1 = null;
                   continue;
               }
               array[j] = order[0];
               counter1++;
           }else if (val2!=null){
               if (counter2==val2) {
                   j--;
                   val2 = null;
                   continue;
               }
               array[j] = order[1];
               counter2++;
           }
           else if (val3!=null){
               if (counter3==val3) {
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



    private static void assignIndexes(int[] array, int[] order, int indStart1,
                                      int indEnd1, int indStart2, int indEnd2, int indStart3, int indEnd3,
                                      HashMap<Integer, Integer> counts) {
        if (counts.containsKey(order[0])) {
            indEnd1 = counts.get(order[0]);
        }
        else if (counts.containsKey(order[1])) {
            indEnd1 = counts.get(order[1]);
        }
        else if (counts.containsKey(order[2])) {
            indEnd1 = counts.get(order[2]);
        }

        if (counts.containsKey(order[1]) && counts.containsKey(order[0]) && counts.containsKey(order[2])){
            indEnd2 = indStart1 + counts.get(order[1]);
            indStart3 = indEnd2 + 1;
            indEnd3 = array.length - 1;
        }else if (!counts.containsKey(order[0])){
            indStart3 = indEnd1 + 1;
            indEnd3 = array.length - 1;
        }else if (!counts.containsKey(order[2])){
            indStart3 = indEnd1 + 1;
            indEnd3 = array.length - 1;
        }

    }

    private static void setStartIndexes(int ind1Value, int ind2Value,
                                        int[] array,
                                        int[] order,
                                        int indStart1,
                                        HashMap<Integer, Integer> counts,
                                        Integer indEnd1,
                                        Integer indEnd2,
                                        Integer indStart2,
                                        Integer indEnd3,
                                        Integer indStart3) {

        indEnd1 = counts.get(ind1Value);
        indStart2 = indEnd1 + 1;
        indEnd2 = indStart1 + counts.get(ind2Value);
        indStart3 = indEnd2 + 1;
        indEnd3 = array.length - 1;
    }
}
