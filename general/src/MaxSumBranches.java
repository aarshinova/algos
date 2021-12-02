import java.util.*;

class MaxSumBranches {

    public static ArrayList<Integer> branchesSumLeft = new ArrayList<>();
    public static ArrayList<Integer> branchesSumRigth = new ArrayList<>();
    public static ArrayList<Integer> branchesMax = new ArrayList<>();

    public static int maxPathSum(BinaryTree tree) {
        branchesMax = new ArrayList<>();
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree currentNode = tree;
        stack.push(currentNode);
        while (stack.size() > 0) {
            currentNode = stack.pop();
            calculateMaxPathSum(currentNode);
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        Collections.sort(branchesMax);
        return branchesMax.get(branchesMax.size() - 1);
    }


    public static void calculateMaxPathSum(BinaryTree tree) {
        branchesSumLeft = new ArrayList<>();
        branchesSumRigth = new ArrayList<>();

        int currentSum = tree.value;
        if (tree != null) {
            maxPathSumHelper(tree.left, currentSum, branchesSumLeft);
            maxPathSumHelper(tree.right, currentSum, branchesSumRigth);
        }

        Collections.sort(branchesSumLeft);
        Collections.sort(branchesSumRigth);

        int size1 = branchesSumLeft.size();
        int size2 = branchesSumRigth.size();

        Integer tmpMaxSumLeft = null;
        Integer tmpMaxSumRight = null;
        if (size1 > 0)
            tmpMaxSumLeft = branchesSumLeft.get(size1 - 1);
        if (size2 > 0 && tree.left != null && tree.right != null)
            tmpMaxSumRight = branchesSumRigth.get(size2 - 1) - tree.value;

        int max = -1;
        if (tmpMaxSumRight != null && tmpMaxSumRight > tmpMaxSumLeft) {
            max = Math.max(tmpMaxSumRight, tmpMaxSumRight + tmpMaxSumLeft);
        } else if (tmpMaxSumRight != null) {
            max = Math.max(tmpMaxSumLeft, tmpMaxSumRight + tmpMaxSumLeft);
        } else {
            max = tmpMaxSumLeft;
        }
        branchesMax.add(max);
    }

    public static void maxPathSumHelper(BinaryTree tree, int currentSum, ArrayList<Integer> branchesSum) {
        if (tree == null) {
            branchesSum.add(currentSum);
            return;
        }
        currentSum += tree.value;
        maxPathSumHelper(tree.left, currentSum, branchesSum);
        maxPathSumHelper(tree.right, currentSum, branchesSum);
        branchesSum.add(currentSum);
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
