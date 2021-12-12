import java.util.ArrayList;

public class TreeDiameterBST {

    static int maxPath = -1;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);

       tree.left.right = new BinaryTree(5);
       tree.left.left = new BinaryTree(4);

       tree.right.left = new BinaryTree(6);
       tree.right.right = new BinaryTree(7);

       binaryTreeDiameter(tree);
       System.out.println("the end " + maxPath);
    }

    private static int binaryTreeDiameter(BinaryTree tree) {
        return binaryTreeDiameterHelper(tree).path;
    }

    public static TreeInfo binaryTreeDiameterHelper(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo ts1 = binaryTreeDiameterHelper(tree.left);
        TreeInfo ts2 = binaryTreeDiameterHelper(tree.right);

        TreeInfo ts = new TreeInfo();

        ts.height = Math.max(ts1.height, ts2.height) + 1;
        ts.path = ts1.height + ts2.height;

        maxPath = Math.max(maxPath, ts.path);

        return ts;

    }

    static class TreeInfo {
        public int height;
        public int path;
        TreeInfo(){

        }
        TreeInfo(int height, int path){
            this.height = height;
            this.path = path;
        }
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
