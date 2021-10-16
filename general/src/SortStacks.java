import java.util.ArrayList;
import java.util.Arrays;

public class SortStacks {
    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<Integer>(Arrays.asList(-5, 2, -2, 4, 3, 1));
        System.out.println("Result :" + sortStack(stack));
    }

    public static ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size()==0){
            return stack;
        }

        int val = stack.remove(stack.size()-1);

        sortStack(stack);

        insertValueInStack(val, stack);

        return stack;
    }

    private static void insertValueInStack(int val, ArrayList<Integer> stack) {
        if (stack.isEmpty() || stack.get(stack.size()-1)<val){
            stack.add(val);
            return;
        }
        else {
            int top = stack.remove(stack.size()-1);
            insertValueInStack(val, stack);
            stack.add(top);
        }
    }
}
