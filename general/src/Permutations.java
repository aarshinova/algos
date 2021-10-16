import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutations {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(getPermutations(input));
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        findAllPermutations(0, array, permutations);
        return permutations;
    }

    public static void findAllPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size()-1) {
            permutations.add(new ArrayList<>(array));
        } else {
            for (int k = i; k < array.size(); k++) {
                swap(i, k, array);
                findAllPermutations(i+1, array, permutations);
                swap(i, k, array);
            }
        }
    }

    public static void swap(int i, int j, List<Integer> array) {
        int tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }


}
