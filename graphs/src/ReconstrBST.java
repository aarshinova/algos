import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstrBST {

    public static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> preOrderTraversalValues =
                new ArrayList<>(Arrays.asList(5, 6, 7, 8));
       reconstructBst(preOrderTraversalValues);
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST tree=null;
        int arrSize = preOrderTraversalValues.size();
        int mid = arrSize-1;
        // change here
        while (mid-1>=0 && preOrderTraversalValues.get(mid)>preOrderTraversalValues.get(0)){
            mid = mid - 1;
        }

        tree = new BST(preOrderTraversalValues.get(0));
        int leftSubtree = mid, next, curr;
        for (int i = 0; i < mid; i++) {
            next = preOrderTraversalValues.get(i + 1);
            curr = preOrderTraversalValues.get(i);
            if (next > curr) {
                leftSubtree = i;
                break;
            }
        }

        constLeftSide(tree, 0, leftSubtree, preOrderTraversalValues);

        leftSubtree++;
        while (leftSubtree<=mid){
            addToTree(tree.left, preOrderTraversalValues.get(leftSubtree));
            leftSubtree++;
        }

        mid++;
        int rightSubTree = arrSize-1;
        for (int i=mid; i<arrSize-1; i++){
            next = preOrderTraversalValues.get(i+1);
            curr = preOrderTraversalValues.get(i);
            if (next<curr){
                rightSubTree = i;
                break;
            }
        }

        constRightSide(tree, mid, rightSubTree, preOrderTraversalValues);

        rightSubTree++;
        while (rightSubTree<arrSize){
            addToTree(tree.right, preOrderTraversalValues.get(rightSubTree));
            rightSubTree++;
        }
        return tree;
    }

    private static BST addToTree(BST tree, Integer value) {
        if (tree == null){
            return new BST(value);
        }
        if (tree.value<=value){
            tree.right = addToTree(tree.right, value);
        }else if (tree.value>value){
            tree.left = addToTree(tree.left, value);
        }

        return tree;
    }


    public static void constRightSide(BST tree, int i, int depth, ArrayList<Integer> preOrderTraversalValues){
        if (i>depth) {
            return;
        }else {
            if (i>=preOrderTraversalValues.size())
                return;
            tree.right = new BST(preOrderTraversalValues.get(i));
            i++;
            constRightSide(tree.right, i, depth, preOrderTraversalValues);
        }
    }

    public static void constLeftSide(BST tree, int i, int depth, ArrayList<Integer> preOrderTraversalValues){
        if (i==depth) {
            return;
        }else {
            i++;
            tree.left = new BST(preOrderTraversalValues.get(i));
            constLeftSide(tree.left, i, depth, preOrderTraversalValues);
        }
    }
}
