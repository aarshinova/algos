import java.util.Arrays;
import java.util.Comparator;

public class InterlapingIntervals {
    public static void main(String[] args) {
        int[][] intervals =
                new int[][] {
                        {1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}
                };
        int[][] result = mergeOverlappingIntervals(intervals);
        System.out.println(result);
    }



    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        int[][] results = new int[intervals.length][2];
        int j = 0;
        int rightSidePrev = intervals[0][1];
        for (int i=1; i<intervals.length;i++){
            int[] currInterval = intervals[i];

            if (rightSidePrev>=currInterval[0]){
                results[j][0] = intervals[i-1][0];
                results[j][1] = currInterval[1];
                j++;
            }else {
                results[j][0] = intervals[i-1][0];
                results[j][1] = intervals[i-1][1];;
                j++;
            }
            rightSidePrev = currInterval[1];
        }
        return results;
    }
}
