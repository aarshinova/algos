import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class InterlapingIntervals {
    public static void main(String[] args) {
        int[][] intervals =
                new int[][] {
                        {1, 22}, {-22, 30}
                };
        int[][] result = mergeOverlappingIntervals(intervals);
        System.out.println(result);
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        int[][] results = new int[intervals.length][2];
        int j = 0;
        int[] prevInterval = intervals[0];
        for (int i=1; i<intervals.length;i++){
            int[] currInterval = intervals[i];

            if (prevInterval[1]>=currInterval[0]){
                results[j][0] =(prevInterval[0]<currInterval[0])?  prevInterval[0]: currInterval[0];
                results[j][1] =(prevInterval[1]<currInterval[1])? currInterval[1]: prevInterval[1];


                prevInterval = results[j];
                if (i==intervals.length-1){
                    j++;
                }
            }else {
                results[j][0] = prevInterval[0];
                results[j][1] = prevInterval[1];
                prevInterval = currInterval;
                j++;
                if (i==intervals.length-1){
                    results[j][0] = currInterval[0];
                    results[j][1] = currInterval[1];
                    j++;
                }
            }
        }
        int[][] resultsFinal = new int[j][2];
        for (int i=0;i<j;i++){
            resultsFinal[i][0] = results[i][0];
            resultsFinal[i][1] = results[i][1];
        }

        return resultsFinal;
    }
}
