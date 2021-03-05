//Given an integer array A of size N.
//
//        You can pick B elements from either left or right end of the array A to get maximum sum.
//        Find and return this maximum possible sum.
//
//        NOTE: Suppose B = 4 and array A contains 10 elements then:
//
//        You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc .
//        you need to return the maximum possible sum of elements you can pick.
//         [1, 3, 2, 5, 7, 2, 9] B=3  => 1+3+2 (6) 7 + 2 + 9 (18)
//          1 2 9 = > 12
//          1 + 3 + 9 => 13
//          9 + 1 + 3 => 13

public class NodeDepths {
    public static int treeDepth = 0;
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

        System.out.println("Result is " + findNodesDepth(root));
    }

    public static int findNodesDepth(BST tree) {
        int nbVisit = 0;
        findNodesDepthInBST(tree, nbVisit);
        return treeDepth;
    }

    private static void findNodesDepthInBST(BST root, int nbVisit) {
        nbVisit++;
        if (root.left!=null){
            findNodesDepthInBST(root.left, nbVisit);
        }
        if (root.right!=null){
            findNodesDepthInBST(root.right, nbVisit);
        }
        treeDepth+=(nbVisit-1);
        return;
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
