import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsDFS {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        boolean[] visited = new boolean[input.size()];
        Arrays.fill(visited, false);
        permutations(input, 0, new int[input.size()], visited);
    }

      //     0
    // |     |     |
    // a     b     c
    // |     |      |
  // b  c   a  c   a  b
  // |  |
  // c  b

    /*Solution using DFS*/
    public static void permutations(List<Integer> array, int level, int[] branch, boolean[] visited) {
        if (level>array.size()-1){
            System.out.println("Result : ");
            for (int i=0; i<branch.length; i++) {
                System.out.print(branch[i]);
            }
            System.out.println();
            return;
        }
        for (int i=0; i<array.size(); i++){
            if (!visited[i]) {
                branch[level] = array.get(i);
                visited[i] = true;
                level++;
                permutations(array, level, branch, visited);
                visited[i] = false;
                level--;
            }
        }
    }

}
