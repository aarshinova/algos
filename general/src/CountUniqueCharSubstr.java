import java.util.*;

class PowerSetIteration {
    public static void main(String[] args) {
        // 135 1245
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        powerset(input);
      //  System.out.println(powerset(input));
        System.out.println(powerset(input).size());
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        for (Integer el:array){
            int length = result.size();
            for (int i=0; i<length; i++){
                List<Integer> currentRes = new ArrayList<>(result.get(i));
                System.out.println("i " + i);
             //   System.out.println("length " + length);
                System.out.println("current el : " + el);
                currentRes.add(el);
                result.add(currentRes);
                System.out.println("current result after : " + result);
            }
        }
        return result;
    }

}
