//Given an integer array A of size N.
//
//        You can pick B elements from either left or right end of the array A to get maximum sum.
//        Find and return this maximum possible sum.
//
//        NOTE: Suppose B = 4 and array A contains 10 elements then:
//
//        You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc .
//        you need to return the maximum possible sum of elements you can pick.
//         [1, 3, 2, 5, 7, 2, 9] B=3  => 1+3+2 (6) 7 + 2 + 9 (18)
//          1 2 9 = > 12
//          1 + 3 + 9 => 13
//          9 + 1 + 3 => 13

public class pick_both_sides {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 7, 2, 9, 5, 2};
        int b = 3;
        System.out.println("Result 1 " + pickBothSides(arr, b));
        arr = new int[]{1, 3, 2, 5, 7, 2, 9, 5};
        b = 5;
        System.out.println("Result 2 " + pickBothSides(arr, b));
        arr = new int[]{1, 3, 2, 5, 7, 2, 9, 5};
        b = 1;
        System.out.println("Result 3 " + pickBothSides(arr, b));
        arr = new int[]{ -969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587 };
        b = 81;
        System.out.println("Result 4 " + pickBothSides(arr, b));
    }

    private static int pickBothSides(int[] A, int B) {
            if (A.length==1) return A[0];
            int max1 = 0;
            int max=0;
            for (int j = (A.length - 1); j > (A.length - B - 1); j--) {
                max += A[j]; //16
            }
            int size = B;
            for (int i = 0; i < B; i++) {
                max1 += A[i]; //1
                size--; //0
                int max2 = 0;
                for (int j = (A.length - 1); j > (A.length - size - 1); j--) {
                    max2 += A[j];
                }
                int maxTmp = max1 + max2; //8, 6, 6
                if (maxTmp > max) max = maxTmp; // 8
            }

            return max;
    }
}
