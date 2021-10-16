class SelectionSort {
    public static void main(String[] args) {
        System.out.println(selectionSort(new int[]{7, 6, 4, 2, 9, 6, 3}));
    }

    public static int[] selectionSort(int[] array) {
        int min;
        int pos;
        for (int i = 0; i < array.length; i++) {
            int j = i;
            min = array[i];
            pos = i;
            while (j < array.length) {
                if (min > array[j]) {
                    min = array[j];
                    pos = j;
                }
                j++;
            }
            swap(pos, i, array);
        }
        return array;
    }

    public static void swap(int ind1, int ind2, int[] array) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }


}
