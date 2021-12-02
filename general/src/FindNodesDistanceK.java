import java.util.*;

class FindNodesDistanceK {
    public static BinaryTree targetNode = null;
    // This is an input class. Do not edit.
    // O(m) m - number of nodes, O(m)
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        targetNode = null;
        ArrayList<BinaryTree> visitedNodes = new ArrayList<>();
        findPathToNode(tree, target, visitedNodes);

        //ugly
        ArrayList<Integer> visitedNodesInt = new ArrayList<>();
        for (BinaryTree node : visitedNodes){
            visitedNodesInt.add(node.value);
        }

        // go up from target node
        ArrayList<Integer> nodeValuesRoot = new ArrayList<>();
        // k is too big, going on the other side of the tree
        if (k > visitedNodes.size() - 1 ){ // 1 3
            int newK = k - (visitedNodes.size()-1);
            findTargetNode(tree, tree, target, newK, 0, nodeValuesRoot, visitedNodesInt, false);
        }
        else {
            // k is still on the same branch, so we need to explore all sub-branches
            int newK = k - 1; // 0
            for (int i=(visitedNodes.size()-2); i>=0 && newK>=0; i--){
                if (newK==0){
                    nodeValuesRoot.add(visitedNodes.get(i).value);
                }else{
                    findTargetNode(tree, visitedNodes.get(i), target, newK, 0, nodeValuesRoot, visitedNodesInt, true);
                }
                newK--;
            }
        }

        // go down k step from target node
        ArrayList<Integer> nodeValues = new ArrayList<>();
        //visitedNodesInt.size()>1 - edgge case we start from root
        if (targetNode!=null && visitedNodesInt.size()>1) {
            findTargetNode(tree, targetNode, target, k, 0, nodeValues, visitedNodesInt, true);
        }

        nodeValuesRoot.addAll(nodeValues);

        return nodeValuesRoot;
    }


    public boolean findPathToNode(BinaryTree node, int target, ArrayList<BinaryTree> visitedNodes) {
        if (node==null){
            return false;
        }

        visitedNodes.add(node);

        if (node.value == target) {
            targetNode = node;
            return true;
        }

        if  (findPathToNode(node.left, target, visitedNodes) ||
                findPathToNode(node.right, target, visitedNodes)) {
            return true;
        }

        visitedNodes.remove(visitedNodes.size()-1);
        return false;

    }

    public void findTargetNode(BinaryTree root, BinaryTree node, int target, int k, int distanceCount,
                               ArrayList<Integer> nodeValues, ArrayList<Integer> visitedNodes, boolean startFromTarget){
        if (node==null || (visitedNodes.contains(node.value) && node.value!=root.value && !startFromTarget)){
            return;
        }

        if (distanceCount == k && node.value!=target) {
            nodeValues.add(node.value);
        }

        distanceCount++;

        findTargetNode(root, node.left, target, k, distanceCount, nodeValues, visitedNodes, startFromTarget);
        findTargetNode(root, node.right, target, k, distanceCount, nodeValues, visitedNodes, startFromTarget);
    }
}
