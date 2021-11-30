import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {

        List<List<Integer>> test = new ArrayList<List<Integer>>();

        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));

        System.out.println("length " + test.size());
        System.out.println("height " + test.get(0).size());
        System.out.println(test.get(0).get(1));

        Integer foo = 1;
        changeFoo(foo);
        System.out.println("Foo now " + foo);

        int[] arr = {1,2};
        changeArr(arr);
        System.out.println("Arr now " + arr[0] + " " + arr[1]);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(9);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(9);
        System.out.println(arr1.containsAll(arr2));

    }

    private static void changeArr(int[] arr) {
        arr[0] = 5;
        arr[1] = 8;
    }

    private static void changeFoo(Integer foo) {
    }
}
