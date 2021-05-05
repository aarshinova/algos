public class ArraysOfProducts {
    public static void main(String[] args) {

        int[] output3 = arrayOfProducts(
                new int[] {5,1,4,2});

        for (int r : output3) {
            System.out.println("output " + r);
        }
    }

    // 5 1 4 2

    // 0  -
    // 1 - 5
    // 2 5*1
    // 3 5 * 1 *4

    // 0 5 5 20

    public static int[] arrayOfProducts(int[] array) {
        int[] res = new int[array.length];
        int cumulativeVal = 1;
        res[0] = 1;
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                cumulativeVal *= array[i - 1];
                res[i] = cumulativeVal;
            }
        }
        cumulativeVal = 1;
        for (int j = array.length - 1; j >= 0; j--) {
            if (j != array.length - 1) {
                cumulativeVal *= array[j + 1];
                res[j] *= cumulativeVal;
            }
        }

        return res;
    }
}
