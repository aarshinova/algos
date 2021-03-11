// Tournament winner
public class ThreeSum {
    public static void main(String[] args) {
        int[] res = findThreeLargestNumbers(new int[]{7, 7, 7});
        for (int el : res) {
            System.out.println("res is " + el);
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] maxArr = new int[3];
        Integer tmp;
        initMax(maxArr, array);
        for (int i = 3; i < array.length; i++) {
            if (array[i] > maxArr[2]) {
                tmp = maxArr[2];
                maxArr[2] = array[i];
                replaceMaxes(tmp, 0, 1, maxArr);
            } else if (array[i] > maxArr[1]) {
                tmp = maxArr[1];
                maxArr[1] = array[i];
                replaceMaxes(tmp, 0, 2, maxArr);
            } else if (array[i] > maxArr[2]) {
                tmp = maxArr[0];
                maxArr[0] = array[i];
                replaceMaxes(tmp, 1, 2, maxArr);
            }
        }
        //sort
        if (array.length == 3) {
            int max = maxArr[0];
            int min = maxArr[1];
            for (int i = 0; i < 3; i++) {
                if (maxArr[i] > max) {
                    max = maxArr[i];
                }
                if (maxArr[i] < min) {
                    min = maxArr[i];
                }
            }
            Integer mid = null;
            for (int el : maxArr) {
                if (el != min && el != max) {
                    mid = el;
                }
            }
            if (mid == null) {
                mid = array[0];
            }
            maxArr[0] = min;
            maxArr[1] = mid;
            maxArr[2] = max;
        }

        return maxArr;
    }

    public static void initMax(int[] maxArr, int[] arr) {
        maxArr[0] = arr[0];
        maxArr[1] = arr[1];
        maxArr[2] = arr[2];
    }

    public static void replaceMaxes(int tmp, int firstMaxIdx, int secondMaxIdx, int[] array) {
        if (tmp > array[firstMaxIdx]) {
            int tmp2 = array[firstMaxIdx];
            array[firstMaxIdx] = tmp;
            if (tmp2 > array[secondMaxIdx]) {
                array[secondMaxIdx] = tmp2;
            }
            return;
        }
        if (tmp > array[secondMaxIdx]) {
            int tmp2 = array[secondMaxIdx];
            array[secondMaxIdx] = tmp;
            if (tmp2 > array[firstMaxIdx]) {
                array[firstMaxIdx] = tmp2;
            }
            return;
        }
    }

    // 141 1 17
    // 141 18 17
    // 541 18 17
}
