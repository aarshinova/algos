import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class RemoveIslands {
    public static Boolean borderFound = false;
    public static void main(String[] args) {
        int[][] input =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };

        int[][] result = removeIslands(input);
        for (int i=0;i<result.length;i++){
            for (int j=0; j< result[i].length; j++) {
                System.out.println("[" + result[i][j] + "]");
            }
        }

    }

    public static int[][] removeIslands(int[][] matrix) {
        for (int i=0;i<matrix.length;i++) {
            for (int j=0; j< matrix[i].length; j++) {
                ArrayList<List<Integer>> localPath = new ArrayList<>();
                borderFound = false;
                checkIsland(i, j, matrix, localPath);
                for (List<Integer> cel : localPath){
                    matrix[cel.get(0)][ cel.get(1)] =  (borderFound?1:0);
                }
            }
        }

        return matrix;
    }

    public static void checkIsland(int i, int j, int[][] matrix, ArrayList<List<Integer>> path) {
        if (checkIfBorder(i, j, matrix)) {
            boolean borderCase = (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[i].length - 1);
            if (borderCase && matrix[i][j] == 1) {
                matrix[i][j] *= -1;
                path.add(Arrays.asList(i, j));
                borderFound = true;
                return;
            }
            return;
        }

        if (matrix[i][j] == 1) {
            path.add(Arrays.asList(i, j));
            matrix[i][j] *= -1;
            checkIsland(i, j-1, matrix, path);
            checkIsland(i, j+1, matrix, path);
            checkIsland(i-1, j, matrix, path);
            checkIsland(i+1, j, matrix, path);
        }else {
            return;
        }

        return;
    }

    public static boolean checkIfBorder(int i, int j, int[][] matrix){
        if (i<=0 || j<=0 || i>=matrix.length-1 || j >= matrix[i].length-1) {
            return true;
        }
        return false;
    }

}
