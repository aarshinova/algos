import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PowerSet {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(powerset(input));
    }

    public static ArrayList<ArrayList<Integer>> powerset(List<Integer> array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<>());
        findPowerset(0, array, result);
        return result;
    }

    private static void findPowerset(int i, List<Integer> array, ArrayList<ArrayList<Integer>> result) {
        for (int k=i; k<array.size(); k++){
            addToArray(i, array, result);
            findPowerset(i+1, array, result);
            addToArray(i, array, result);
        }
    }

    private static void addToArray(int i, List<Integer> array, ArrayList<ArrayList<Integer>> result) {
        ArrayList arr = new ArrayList<>();
        arr.add(array.get(i));
        result.add(arr);
    }


}
