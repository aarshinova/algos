import java.util.*;

public class MinMaxStackProgram {
    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }

    public static void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        System.out.println(stack.getMin() == min);
        System.out.println(stack.getMax() == max);
        System.out.println(stack.peek() == peek);
    }

    // Feel free to add new properties and methods to the class.
     public static class MinMaxStack {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        List<Integer> minMaxStack = new ArrayList<>();
        public int peek() {
           return minMaxStack.get(minMaxStack.size()-1);
        }

        public int pop() {
            min.remove(min.size()-1);
            max.remove(max.size()-1);
            return minMaxStack.remove(minMaxStack.size()-1);
        }

        public void push(Integer number) {
            if (min.size()>0){
                int minToPush = Math.min(number, min.get(min.size()-1));
                min.add(minToPush);
            }else {
                min.add(number);
            }
            if (max.size()>0){
                int maxToPush = Math.max(number, max.get(max.size()-1));
                max.add(maxToPush);
            }else {
                max.add(number);
            }

            minMaxStack.add(number);
        }

        public int getMin() {
            return min.get(min.size()-1);
        }

        public int getMax() {
            return max.get(max.size()-1);
        }
    }
}
