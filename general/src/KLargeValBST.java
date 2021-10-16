import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KLargeValBST {

    public static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        BST root = new BST(15);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.left.right = new BST(3);
        root.left.right = new BST(5);
        root.right = new BST(20);
        root.right.left = new BST(17);
        root.right.right = new BST(22);
        System.out.println("the result is " + findKthLargestValueInBst(root, 3));
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    // 1 2 3 4 5 6 7     - 7
    public static int findKthLargestValueInBst(BST tree, int k) {
        findKValueHelper(tree);
        if (k!=0) {
            return res.get(res.size()-k);
        }else {
           return res.get(res.size()-1);
        }
    }

    private static void findKValueHelper(BST tree) {
        if (tree==null){
            return;
        }
        findKValueHelper(tree.left);
        res.add(tree.value);
        findKValueHelper(tree.right);
    }
}
