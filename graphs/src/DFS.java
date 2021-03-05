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

import java.util.Arrays;

public class ClosestBST {
    public static int closestValue = -1;
    public static int diff = -1;
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

        var expected = 13;
        System.out.println("Result " + findClosestValueInBst(root, 12));
    }

    public static int findClosestValueInBst(BST tree, int target) {
        searchInBST(tree, target);
        return closestValue;
    }

    private static void searchInBST(BST side, int target) {
        if (side.value==target){
            closestValue=target;
            return;
        }
        int absDiff = Math.abs(target - side.value);
        if (absDiff<diff || diff==-1){
            diff = absDiff;
            closestValue = side.value;
        }
        else if (absDiff<diff || diff==-1){
            diff = absDiff;
            closestValue = side.value;
        }
        if (side.value>target){
            if (side.left!=null) {
                searchInBST(side.left, target);
            }else {
                return;
            }
        }else if (side.value<target){
            if (side.right!=null) {
                searchInBST(side.right, target);
            }else {
                return;
            }
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
