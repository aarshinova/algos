import java.util.*;

public class GetGreaterNext {
    public static void main(String[] args) {
        int[] input = new int[]{2, 5, -3, -4, 6, 7, 2};
        System.out.println("Result :" + nextGreaterElement(input));
    }

    public static int[] nextGreaterElement(int[] array) {
        //Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < array.length * 4; i++) {
            int indx = i % array.length;
            int curr = array[indx];
            while (!stack.isEmpty() && array[stack.peek()]<curr){
                int j = stack.pop();
                result[j] = curr;
            }
            stack.add(indx);
        }
        return result;
    }
}
