import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SunsetViews {
    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(7);
        System.out.println("Result :" + sunsetViews(buildings, direction));
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();
        if (direction.equalsIgnoreCase("EAST")) {
            ArrayList<Integer> tmpRes = new ArrayList<>();
            for (int i=buildings.length-1;i>=0;i--){
                 if (tmpRes.size()>0){
                     int lastBuild = buildings[tmpRes.get(tmpRes.size()-1)];
                     if (buildings[i]>lastBuild) {
                         tmpRes.add(i);
                     }
                 }else {
                     tmpRes.add(i);
                 }
             }
            for (int j=tmpRes.size()-1; j>=0; j--){
                result.add(tmpRes.get(j));
            }
         }else {
            for (int i=0;i<buildings.length;i++){
                if (result.size()>0){
                    int lastBuild = buildings[result.get(result.size()-1)];
                    if (buildings[i]>lastBuild) {
                        result.add(i);
                    }
                }else {
                    result.add(i);
                }
            }
         }
        return result;
    }
}
