import java.util.ArrayList;
import java.util.HashMap;

class SearchSortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 12, 15, 1000},
                {2, 5, 19, 31, 32, 1001},
                {3, 8, 24, 33, 35, 1002},
                {40, 41, 42, 44, 45, 1003},
                {99, 100, 103, 106, 128, 1004},
        };
        int[] output = searchInSortedMatrix(matrix, 99);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        int currInd = matrix[x][y];
        boolean found = true;

        while (currInd != target) {
            if (target < currInd) {
                if ((y - 1) < 0 || (y - 1) >= matrix[0].length) {
                    found = false;
                    break;
                }
                currInd = matrix[x][--y];
            }
            if (target > currInd) {
                if ((x + 1) < 0 || (x + 1) >= matrix.length) {
                    found = false;
                    break;
                }
                currInd = matrix[++x][y];
            }
        }

        return (found ? new int[]{x, y} : new int[]{-1, -1});
    }
}
