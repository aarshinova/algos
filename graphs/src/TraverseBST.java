import java.util.ArrayList;
import java.util.List;

public class TraverseBST {
    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree!=null) {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree!=null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree!=null) {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
