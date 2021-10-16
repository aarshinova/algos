import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Tournament winner
public class ProductSum {

    public static void main(String[] args) {
        List<Object> test =
                new ArrayList<Object>(
                        Arrays.asList(
                                5,
                                2,
                                new ArrayList<Object>(Arrays.asList(7, -1)),
                                3,
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        System.out.println((productSum(test)));
        System.out.println((productSum(test) == 12));
    }

    // 5 + 2 = 7
    // 7 + 14 = 21,  21 - 2 = 19
    // 19 + 3 = 22
    // 22 + 2*6 = 34
    // 34 - 13+3 = -5
    // -5 + 3*8 = 19
    // 19 + 4*2 = 27

    public static int productSum(List<Object> array) {
        return findProductSum(array, 1);
    }

    public static int findProductSum(List<Object> array, int depth) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof Integer) {
                sum += depth * (Integer) obj;
            } else if (obj instanceof ArrayList) {
                sum += depth * findProductSum((ArrayList<Object>) obj, depth+1);
            }
        }
        return sum;
    }

}
