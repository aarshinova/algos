import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static int len = 0;
    public static void main(String[] args) {

        int[][] input = {
                        {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                        {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                        {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                        {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };
        System.out.println(" The result is " + riverSizes(input));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                fetchNext(matrix, i, j);
                if (len!=0) res.add(len);
                len=0;
            }
        }
        return res;
    }

    private static void fetchNext(int[][] matrix, int i, int j) {
        // boundaries checks
        if (i<0 || i>= matrix.length || j<0 || j>=matrix[0].length){
            return;
        }
        int curr = matrix[i][j];
        if (curr==1) {
            matrix[i][j] *= -1;
            fetchNext(matrix,i,j-1);
            fetchNext(matrix,i,j+1);
            fetchNext(matrix,i-1,j);
            fetchNext(matrix,i+1,j);
            len++;
            return;
        }
        else {
            return;
        }
    }
}

