public class BSTImplementation {
    public static void main(String[] args) {
        var root = new BST(10);
//        root.left = new BST(5);
//        root.left.left = new BST(2);
//        root.left.left.left = new BST(1);
//        root.left.right = new BST(5);
//        root.right = new BST(15);
//        root.right.left = new BST(13);
//        root.right.left.right = new BST(14);
//        root.right.right = new BST(22);

//        root.insert(5);
//        System.out.println(root.right.left.left.value == 12);
//        root.remove(10);
//        System.out.println(root.value == 12);
//        System.out.println(root.contains(15));

        root.insert(5);
        root.insert(15);
        root.insert(20);
        root.remove(15);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            bstInsertHelper(null, this, value);
            return this;
        }

        public boolean contains(int value) {
            return bstContainsHelper(this, value);
        }

        public BST remove(int value) {
            bstRemoveHelper(this, null, value, false);
            return this;
        }

        public void bstRemoveHelper(BST node, BST prevNode, int valueToRemove, boolean isLeft) {
            if (node != null) {
                if (valueToRemove < node.value) {
                    prevNode = node;
                    bstRemoveHelper(node.left, prevNode, valueToRemove, true);
                } else if (valueToRemove > node.value) {
                    prevNode = node;
                    bstRemoveHelper(node.right, prevNode, valueToRemove, false);
                } else if (valueToRemove == node.value) {
                    BST nodeToRemove = node;
                    // no children case
                    if (nodeToRemove.left == null && nodeToRemove.right == null) {
                        if (isLeft && prevNode!=null) prevNode.left = null;
                        else if (!isLeft && prevNode!=null) prevNode.right = null;
                        else nodeToRemove = null;
                    }
                    // one child case
                    else if ((nodeToRemove.left != null && nodeToRemove.right == null) || (nodeToRemove.right != null && nodeToRemove.left == null)) {

                        if (nodeToRemove.left != null && nodeToRemove.right == null){
                            if (prevNode!=null && isLeft) prevNode.left = nodeToRemove.left;
                            if (prevNode!=null && !isLeft) prevNode.right = nodeToRemove.left;
                            else if (prevNode==null) {
                                nodeToRemove.value = nodeToRemove.left.value;
                                if (nodeToRemove.left.left!=null)
                                    nodeToRemove.left = nodeToRemove.left.left;
                                else {
                                    nodeToRemove.left = null;
                                }
                            }
                        }else if (nodeToRemove.right != null && nodeToRemove.left == null){
                            if (prevNode!=null && isLeft) prevNode.left = nodeToRemove.right;
                            if (prevNode!=null && !isLeft) prevNode.right = nodeToRemove.right;
                            else if (prevNode==null) {
                                nodeToRemove.value = nodeToRemove.right.value;
                                if (nodeToRemove.right.right!=null)
                                    nodeToRemove.right = nodeToRemove.right.right;
                                else {
                                    nodeToRemove.right = null;
                                }
                            }
                        }

                    }
                // 2 childs case
                else if (nodeToRemove.left != null & nodeToRemove.right != null) {
                    int replacementValue = findInOrderReplacement(nodeToRemove.right, nodeToRemove.right, 0);
                    nodeToRemove.value = replacementValue;
                    // remove replacement node ( should fail in first 2 cases
                    bstRemoveHelper(nodeToRemove.right, nodeToRemove, replacementValue, false);
                }
            }

        }
    }

        private int findInOrderReplacement(BST node, BST root, Integer prevValue) {
            if (node != null) {
                return findInOrderReplacement(node.left, root, node.value);
            }
            return prevValue;
        }

        public void bstInsertHelper(BST prevNode, BST node, int valToInsert) {
            if (node != null) {
                if (valToInsert < node.value) {
                    // go left
                    prevNode = node;
                    bstInsertHelper(prevNode, node.left, valToInsert);
                } else if (valToInsert >= node.value) {
                    prevNode = node;
                    bstInsertHelper(prevNode, node.right, valToInsert);
                }
            } else {
                //insert
                BST newNode = new BST(valToInsert);
                if (prevNode.value > valToInsert) {
                    prevNode.left = newNode;
                } else if (prevNode.value <= valToInsert) {
                    prevNode.right = newNode;
                }
            }
        }

        public boolean bstContainsHelper(BST node, int valToFind) {
            if (node != null) {
                if (valToFind < node.value) {
                    return bstContainsHelper(node.left, valToFind);
                } else if (node.value == valToFind) {
                    return true;
                } else if (valToFind >= node.value) {
                    return bstContainsHelper(node.right, valToFind);
                }
            }
            return false;
        }
    }
}
