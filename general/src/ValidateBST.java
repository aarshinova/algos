public class ValidateBST {
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

        System.out.println(validateBst(root));

    }

    public static boolean validateBst(BST tree) {
        return validateBstHelper(tree, null, null);
    }

    private static boolean validateBstHelper(BST tree, Integer min, Integer max) {
        if (min!=null && tree.value<min){
            return false;
        }
        else if (max!=null && tree.value>=max){
            return false;
        }

        if (tree.left!=null && !validateBstHelper(tree.left, min, tree.value)){
            return false;
        }
        if (tree.right!=null && !validateBstHelper(tree.right, tree.value, max)){
            return false;
        }
        return true;
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
