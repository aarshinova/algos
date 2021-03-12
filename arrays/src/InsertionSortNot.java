class InsertionSort {
    public static void main(String[] args) {
        System.out.println(insertionSort(new int[]{7, 6, 4, 2, 9, 6, 3}));
    }

    public static int[] insertionSort(int[] array) {
       for (int i=0; i<array.length; i++){
           int j=i;
           while (j>=1 && array[j]<array[j-1]){
               swap(j, j-1, array);
               j--;
           }
       }
       return array;
    }

    public static void swap(int ind1,int ind2, int[] array){
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
