import java.util.*;

class FourSum {

    public static void main(String[] args) {
        List<Integer[]> output = fourNumberSum(new int[]{7, 6, 4, -1, 1, 2}, 16);
        for (Integer[] res : output) {
            for (Integer el : res) {
                System.out.print(el + " ");
            }
            System.out.println();
            System.out.println();
        }
    }


    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer[]>> valueSet = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int val1 = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int val2 = array[j];
                int sum = val1 + val2;
                Integer[] arr = new Integer[]{val1, val2};
                if (valueSet.containsKey(sum)) {
                    ArrayList<Integer[]> tmp = valueSet.get(sum);
                    tmp.add(arr);
                    valueSet.put(sum, tmp);
                } else {
                    ArrayList<Integer[]> tmp = new ArrayList<>();
                    tmp.add(arr);
                    valueSet.put(sum, tmp);
                }
            }
        }
       for (Integer sum: valueSet.keySet()){
           int remSum = targetSum - sum;
           if (valueSet.containsKey(remSum)){
               for (Integer[] sum1 : valueSet.get(sum)){
                   for (Integer[] sum2 : valueSet.get(remSum)){
                       if ((sum1[0]!=sum2[0] && sum1[0]!=sum2[1]) && (sum1[1]!=sum2[0] && sum1[1]!=sum2[1])) {
                           Integer[] res = {sum1[0], sum1[1], sum2[0], sum2[1]};
                           result.add(res);
                       }
                   }
               }
           }
       }


        return result;
    }


}
