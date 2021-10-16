import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        var input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                      //  {10, 9, 8, 7},
                };

//        var input =
//                new int[][] {
//                        {1, 2, 3, 2},
//                        {12, 13, 4},
//                        {11, 14, 5},
//                        {10, 15, 16},
//                        {9, 8, 7},
//                };

//        var input =
//                new int[][] {
//                        {1, 2, 3,5,6,7,8},
//                };

//        var input = new int[][] {
//                {27, 12, 35, 26},
//                {25, 21, 94, 1},
//                {19, 96, 43, 56},
//                {55, 36, 10, 18},
//                {96, 83, 31, 9},
//                {93, 11, 90, 16},
//
//        };
//        var input = new int[][] {
//                {1, 2, 3},
//                {10, 12, 5},
//                {9, 7, 6},

     //   };
        var actual = spiralTraverse(input);
    }

    //{1, 2, 3, 4, 7},
    //{12, 13, 14, 5, 8},
    //{12, 17, 14, 7, 8},
    //{11, 16, 15, 6, 8},
    //{10, 9, 8, 7, 8},

    // 0,1 1,0 2,0 3,0


    public static List<Integer> spiralTraverse(int[][] array) {
        result = new ArrayList<>();
        int leftCornerX = 0;
        int leftCornerY = 0;
        int lengthRows = array.length;
        int lengthCols = array[0].length;
        List<Integer> res = new ArrayList<>();

        if (lengthRows==1 && lengthCols==1) {
            result.add(array[leftCornerX][leftCornerY]);
            return result;
        }

        calculatePerimeter(array, leftCornerX, leftCornerY, lengthRows-1, lengthCols-1);

        return result;
    }

    private static void calculatePerimeter(int[][] array, int leftCornerX, int leftCornerY, int arraySizeX, int arraySizeY) {
        for (int i = leftCornerY; i <= arraySizeY; i++) {
            result.add(array[leftCornerX][i]);
        }

        for (int j = leftCornerX+1; j <= arraySizeX; j++) {
            result.add(array[j][arraySizeY]);
        }
        if (arraySizeX>0)
            for (int l = arraySizeY-1; l >= leftCornerY; l--) {
                if (leftCornerX==arraySizeX) break;
                result.add(array[arraySizeX][l]);
            }
        if (arraySizeY>0)
            for (int m = arraySizeX-1; m > leftCornerX; m--) {
                if (leftCornerY==arraySizeY) break;
                result.add(array[m][leftCornerY]);
            }

        arraySizeX = arraySizeX - 1;
        arraySizeY = arraySizeY - 1;
        leftCornerX = leftCornerX + 1;
        leftCornerY = leftCornerY + 1;

        if (((arraySizeX >= 1 && arraySizeX>=leftCornerX) && (arraySizeY >= 1 && leftCornerY<=arraySizeY))) {
            calculatePerimeter(array, leftCornerX, leftCornerY, arraySizeX, arraySizeY);
        } else {
            return;
        }

    }


}
