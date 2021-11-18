import java.util.Arrays;

class LargestRange {

    public static void main(String[] args) {
        int[] output = largestRange(new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
    }


    public static int[] largestRange(int[] array) {
        // 0 1 3  5 6 7 8 9 10 11 12 15
        int startInd = -1;
        int endInd = -1;


        int startIndTmp = -1;
        int endIndTmp = -1;

        if (array.length == 1) {
            return new int[] {array[0], array[0]};
        }
        if (array.length == 2 && array[1]-array[0]==1) {
            return new int[] {array[0], array[1]};
        }

        Arrays.sort(array);

        for (int i=1; i<array.length; i++){
            if (startIndTmp < 0 && (array[i]-array[i-1]) == 1){
                startIndTmp = i-1;
            }else if (startIndTmp >=0 && (array[i]-array[i-1]) > 1){
                endIndTmp = i-1;
            }
            // edge case
            else if (startIndTmp >=0 && (array[i]-array[i-1]) == 1 && i==array.length-1){
                endIndTmp = i;
            }
            //edge case
            if (startIndTmp >=0 && endIndTmp<0 && (array[i]-array[i-1]) == 1 && i==array.length-1 && startIndTmp==i-1){
                endIndTmp = i;
            }
            // max range
            if (startIndTmp>=0 && endIndTmp>=0){
                if (endInd>0 && (endIndTmp-startIndTmp) > (endInd-startInd)){
                    startInd = startIndTmp;
                    endInd = endIndTmp;
                }else if (endInd<0){
                    startInd = startIndTmp;
                    endInd = endIndTmp;

                }

                startIndTmp = -1;
                endIndTmp = -1;
            }
        }

        return new int[] {array[startInd], array[endInd]};
    }
}
