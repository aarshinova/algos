import java.util.*;

class Validate3Nodes {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        Boolean isValid = false;
        if (validateDescendant(nodeOne, nodeTwo, nodeThree)) {
            isValid  = validateDescendant(nodeTwo, nodeThree, nodeOne);
        }

        if (!isValid) {
            if (validateDescendant(nodeThree, nodeTwo, nodeOne)) {
                isValid  = validateDescendant(nodeTwo, nodeOne, nodeThree);
            }
        }

        return isValid;
    }

    public boolean validateDescendant(BST parent, BST descendant, BST nodeToCheck){
        while (parent!=null) {
            if (parent.value == descendant.value){
                return true;
            }
            if (parent.value == nodeToCheck.value){
                return false;
            }
            if (parent.value > descendant.value) {
                parent = parent.left;
            } else if (parent.value < descendant.value) {
                parent = parent.right;
            }
        }

        return false;
    }
}