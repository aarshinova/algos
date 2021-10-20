import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PowersetDFS {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("result " + powerset(input));
    }

    //     0
    // |     |     |
    // a     b     c
    // |     |
    // b     c
    // |
    // c

    public static List<List<Integer>> powerset(List<Integer> array) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        powerset(array, 0, 0, new ArrayList<>(), result);

        return result;
    }

    /*Solution using DFS*/
    public static void powerset(List<Integer> array, int indx, int level, ArrayList<Integer> branch, ArrayList<List<Integer>> result) {
        if (level == array.size()) {
            return;
        }
        for (int i = indx; i < array.size(); i++) {
            System.out.println(indx);
            branch.add(array.get(i));
            result.add(new ArrayList<>(branch));
            powerset(array, ++indx, ++level, branch, result);
            branch.remove(branch.size() - 1);
            level--;
        }
    }
}
