import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
      // System.out.println("result is " + balancedBrackets2("([])(){}(())()()"));
       //System.out.println("result is " + balancedBrackets2("()[]{}{"));
       System.out.println("result is " + balancedBrackets2("(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"));
    }

    public static boolean balancedBrackets(String str) {
        char curlyOpeningBracket = '{';
        char curlyClosingBracket = '}';
        char squareOpenBrackets = '[';
        char squareCloseBrackets = ']';
        char roundOpenBrackets = '(';
        char roundCloseBrackets = ')';
        char[] stack = new char[str.length()];
        Arrays.fill(stack,' ');
        stack[0] = str.charAt(0);
        int indStack = 1;
        for (int i=1; i<str.length() && indStack<str.length() && indStack>=0; i++){
            if (str.charAt(i) == curlyClosingBracket){
                if (indStack>0 && stack[indStack-1] == curlyOpeningBracket){
                    stack[indStack-1] = ' ';
                    indStack--;
                }
                continue;
            }
            if (str.charAt(i) == squareCloseBrackets){
                 if (indStack>0 && stack[indStack-1] == squareOpenBrackets){
                    stack[indStack-1] = ' ';
                    indStack--;
                }
                continue;
            }
            if (str.charAt(i) == roundCloseBrackets){
            if (indStack>0 && stack[indStack-1] == roundOpenBrackets){
                    stack[indStack-1] = ' ';
                    indStack--;
                }
                continue;
            }
            stack[indStack] = str.charAt(i);
            indStack ++;
        }
        return stack[0]==' '? true:false;
    }

    public static boolean balancedBrackets2(String str) {
        char curlyOpeningBracket = '{';
        char curlyClosingBracket = '}';
        char squareOpenBrackets = '[';
        char squareCloseBrackets = ']';
        char roundOpenBrackets = '(';
        char roundCloseBrackets = ')';
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));
        for (int i=1; i<str.length(); i++){
            char curr = str.charAt(i);
            if (curr==curlyClosingBracket){
                if (stack.lastElement().equals(curlyOpeningBracket)){
                   stack.pop();
                   continue;
                }
                stack.push(curr);
            }
            if (curr == squareCloseBrackets){
                if (stack.lastElement().equals(squareOpenBrackets)){
                    stack.pop();
                    continue;
                }
                stack.push(curr);
            }
            if (curr == roundCloseBrackets){
                if (stack.lastElement().equals(roundOpenBrackets)){
                    stack.pop();
                    continue;
                }
                stack.push(curr);
            }
            if (curr == roundOpenBrackets || curr == squareOpenBrackets || curr == curlyOpeningBracket){
                stack.push(curr);
            }
        }
        return stack.isEmpty()? true:false;
    }
}
