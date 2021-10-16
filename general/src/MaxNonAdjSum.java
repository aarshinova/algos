public class MaxNonAdjSum {

    public static void main(String[] args) {
       int[] arr = {4, 3, 5, 200, 5, 3};
       int res = maxSubsetSumNoAdjacent(arr);
       System.out.println("the end : " + res);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length==0){
            return 0;
        }
        if (array.length==1){
            return array[0];
        }
        int[] maxSums = array.clone();
        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i=2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i-1], array[i]+maxSums[i-2]);
        }
        return maxSums[array.length-1];
    }
}
