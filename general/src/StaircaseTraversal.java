import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class StaircaseTraversal {
    public static HashMap<String, ArrayList<String>> dict = new HashMap<>();

    public static void main(String[] args) {

        var res =  staircaseTraversal(0,3,2, 0);
        System.out.println("Result " + res);
    }

    public static int staircaseTraversal(int sum, int height, int maxSteps, int numberOfWays) {
        if (sum>=height) {
            if (sum == height) {
                return ++numberOfWays;
            }else {
                return numberOfWays;
            }
        }
        for (int i=1; i<=maxSteps;i++) {
           sum += i;
           numberOfWays = staircaseTraversal(sum, height, maxSteps, numberOfWays);
           sum = sum - i;
        }

        return numberOfWays;
    }
}
