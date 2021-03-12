class InsertionSortNot {
    public static void main(String[] args) {
        System.out.println(insertionSortNot(new int[]{7, 6, 4, 2, 9, 6, 3}));
    }

    public static int[] insertionSortNot(int[] array) {
        int j=0;
        for (int i=0; i<array.length-1;){
            int currVal = array[i];
            if (currVal > array[i+1]){
                //go right
                j = i;
                while (currVal>=array[j] && j<=array.length-2 && currVal>array[j+1]){
                    array[j] = array[j+1];
                    j++;
                }
                array[j] = currVal;
            }
            else if (i>=1 && currVal < array[i-1]){
                //go left
                j = i;
                while (currVal<=array[j] && j>=1 && currVal<=array[j-1]){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = currVal;
            }else{
                i++;
            }
        }
        return array;
    }


}
