import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(1, 2);
        minHeightBST(arrList);
    }

    public static BST minHeightBST(List<Integer> array) {
        if (array.size()<=1){
            return new BST(array.get(0));
        }
        int midInd = array.size()/2;
        BST top = new BST(array.get(midInd));

        bstHelper(top, array, 0, midInd);  // 0 1
        bstHelper(top, array, midInd, array.size()-1); // 1 1
        System.out.println(""+top);
        return top;
    }

    public static void bstHelper(BST bst, List<Integer> array, int leftInd, int rightInd){
        if (leftInd==rightInd){
            return;
        }
        int midInd = (leftInd + rightInd)/2;
        if (midInd>leftInd && midInd<rightInd) {
            bst.insert(array.get(midInd));
        }
        if ((leftInd==midInd-1) || (rightInd==midInd+1) || (midInd==leftInd) || (midInd==rightInd)){
            if (leftInd==0){
                bst.insert(array.get(leftInd));
            }
            if (array.size()>2 && (rightInd==array.size()-1)){
                bst.insert(array.get(rightInd));
            }
            return;
        }
        bstHelper(bst, array, leftInd, midInd);
        bstHelper(bst, array, midInd, rightInd);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
