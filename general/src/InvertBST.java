import java.util.ArrayList;
import java.util.Arrays;

public class InvertBST {

    public static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.right.right = new BinaryTree(7);
        tree.right.left = new BinaryTree(6);
        invertBinaryTree(tree);
        System.out.println("the end " + tree);
    }

    public static void invertBinaryTree(BinaryTree tree) {
        invertBSTHelper(tree);
    }

    public static void invertBSTHelper(BinaryTree tree){
        if (tree == null || (tree!=null && tree.left== null && tree.right==null)){
            return;
        }
        // swap
        BinaryTree tmp = null;
        tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
