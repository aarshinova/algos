import java.util.*;

class MinPassMatrix {

    public static int numberPasses = 0;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, -1, -3, 2, 0},{1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int number = minimumPassesOfMatrix(matrix);
        System.out.println("Result is " + number);
    }

    public static int minimumPassesOfMatrix(int[][] matrix) {
        int numberPasses=0;

        Stack<List<Integer>> negatives = new Stack<>();
        Queue<List<Integer>> positives = new LinkedList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int el = matrix[i][j];
                if (el < 0) {
                    negatives.add(Arrays.asList(i, j));
                } else if (el > 0) {
                    positives.add(Arrays.asList(i, j));
                }

            }
        }

        int size = positives.size();
        while (positives.size()>0) {
            List<Integer> coord = positives.poll();
            size--;
            checkNegativeNeighboursToConvert(coord.get(0), coord.get(1), matrix, positives, negatives);
            if (positives.size()>0 && size==0) {
                numberPasses++;
                size=positives.size();
            }
        }

        if (negatives.size()>0) {
            return -1;
        }
        return numberPasses;
    }

    private static boolean checkBorders(int i, int j, int[][] matrix){
        if (i>=0 && j>=0 && i<matrix.length && j<matrix[0].length){
            return true;
        }
        return false;
    }

    private static void checkNegativeNeighboursToConvert(int i, int j, int[][] matrix, Queue<List<Integer>> positives, Stack<List<Integer>> negative) {
        if (checkBorders(i + 1, j, matrix) && matrix[i + 1][j] < 0) {
            matrix[i + 1][j] *= -1;
            positives.add(Arrays.asList(i + 1, j));
            negative.pop();
        }
        if (checkBorders(i - 1, j, matrix) && matrix[i - 1][j] < 0) {
            matrix[i - 1][j] *= -1;
            positives.add(Arrays.asList(i - 1, j));
            negative.pop();
        }
        if (checkBorders(i, j - 1, matrix) && matrix[i][j - 1] < 0) {
            matrix[i][j - 1] *= -1;
            positives.add(Arrays.asList(i, j - 1));
            negative.pop();
        }
        if (checkBorders(i, j + 1, matrix) && matrix[i][j + 1] < 0) {
            matrix[i][j + 1] *= -1;
            positives.add(Arrays.asList(i, j + 1));
            negative.pop();
        }
    }
}
