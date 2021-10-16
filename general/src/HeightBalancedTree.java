public class HeightBalancedTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
       tree.left = new BinaryTree(1);
       tree.right = new BinaryTree(3);
       tree.right.right = new BinaryTree(6);
       tree.left.left = new BinaryTree(4);
       tree.left.right = new BinaryTree(5);
       tree.left.right.left = new BinaryTree(7);
       tree.left.right.right = new BinaryTree(8);
       heightBalancedBinaryTree(tree);
       System.out.println("the end");
    }

    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
       TreeInfo info = getTreeInfo(tree);
       return info.isBalanced;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree==null){
            return new TreeInfo(-1, true);
        }

        TreeInfo tr = getTreeInfo(tree.left);
        TreeInfo tr2 = getTreeInfo(tree.right);

        boolean isBalanced = tr.isBalanced && tr2.isBalanced && Math.abs(tr.height- tr2.height)<=1;
        int height = Math.max(tr.height, tr2.height)+1;
        return new TreeInfo( height,isBalanced);
    }

    public static void heightBalancedBinaryTreeHelper(BinaryTree tree) {
        if (tree.left!=null) {
            heightBalancedBinaryTreeHelper(tree.left);
        }
        if (tree.right!=null){
            heightBalancedBinaryTreeHelper(tree.right);
        }
        if (tree.right==null && tree.left==null){
            TreeInfo tr = new TreeInfo(0, true);
            return;
        }


        return;
    }

    static class TreeInfo {
        public int height;
        public boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
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
