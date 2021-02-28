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

import java.util.ArrayList;
import java.util.List;


public class BrunchSum {
    public static List<Integer> branchSums = null;
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

        for (Integer val : findBrunchSum(root)){
            System.out.println("Value " + val);
        }
    }

    public static List<Integer> findBrunchSum(BST tree) {
        branchSums = new ArrayList<>();
        Integer currentSum = 0;
        lookForBrunchSumInBST(tree, currentSum);
        return branchSums;
    }

    private static void lookForBrunchSumInBST(BST root, Integer currentSum) {
        currentSum+=root.value;
        if (root.left!=null){
            lookForBrunchSumInBST(root.left, currentSum);
        }
        if (root.right!=null){
            lookForBrunchSumInBST(root.right, currentSum);
        }
        if (root.right==null && root.left==null){
            branchSums.add(currentSum);
            return;
        }
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
