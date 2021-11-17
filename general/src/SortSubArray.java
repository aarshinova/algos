class SortSubArray {

    public static void main(String[] args) {
        int[] output = subarraySort(new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }


    public static int[] subarraySort(int[] array) {
        int startIndex = - 1;
        int endIndex = -1;
        int startValue = -1;
        int endValue = -1;

        for (int i=1; i<array.length; i++){
            if (array[i]<array[i-1]){
                if ((startIndex<0) || (startIndex>0 && startValue>array[i])) {
                    startIndex = findRightPositionStart(array, i);
                    startValue = array[i];
                }
            }
        }

        for (int j=array.length-2; j>=0; j--){
            if (array[j]>array[j+1]){
                if ((endIndex<0) || (endIndex>0 && endValue<array[j])) {
                    endIndex = findRightPositionEnd(array, j);
                    endValue = array[j];
                }
            }
        }
        return new int[] {startIndex, endIndex};
    }

    public static int findRightPositionEnd(int[] array, int ind){
        int elToFind = array[ind];
        for (int j=array.length-1; j>=0; j--){
            if (elToFind>array[j]){
                return j;
            }
        }
        return -1;
    }

    public static int findRightPositionStart(int[] array, int ind){
        int elToFind = array[ind];
        for (int i=0; i<array.length; i++){
            if (elToFind<array[i]){
                return i;
            }
        }
        return -1;
    }


}
