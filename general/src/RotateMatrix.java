class RotateMatrix {
//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        // 00 01 02 03 04 05
        // 10 11 12 13 14 15
        // 20 21 22 23 24 25
        // 30 31 32 33 34 35

        int len = matrix[0].length;

        int ind = 0;
        boolean rem = false;
        int newLen = len;
        int i = 1;
        while (len>1) {
            while (i < len){
                newLen = len - 1;
                rotateBorder(matrix, ind, newLen);
                i++;
            }
            i = 1;
            len = len-2;
            ind++;
        }

    }

    public static void rotateBorder(int[][] matrix, int ind, int len){
        int tmp = matrix[ind][ind];

        for (int j = ind + 1; j <= ind + len; j++){
            int tmp2 =  matrix[ind][j];
            matrix[ind][j] = tmp;
            tmp = tmp2;
        }

        for (int j = ind + 1; j<= ind + len; j++){
            int tmp2 =  matrix[j][ind+len];
            matrix[j][ind+len] = tmp;
            tmp = tmp2;
        }

        for (int j = ind + len - 1; j>=ind; j--){
            int tmp2 =  matrix[ind+len][j];
            matrix[ind+len][j] = tmp;
            tmp = tmp2;
        }

        for (int j = ind + len - 1; j>=ind; j--){
            int tmp2 =  matrix[j][ind];
            matrix[j][ind] = tmp;
            tmp = tmp2;
        }
    }
}