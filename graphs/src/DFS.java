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

public class DFS {

    public static void main(String[] args) {

        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};
        List<String> inputArray = new ArrayList<String>();
        System.out.println(" compare resuts " + compare(graph.depthFirstSearch(inputArray), expected));
    }

    public static boolean compare(List<String> arr1, String[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (!arr1.get(i).equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
             return doDepthFirstSearch(this, array) ;
        }


        public List<String> doDepthFirstSearch(Node child, List<String> array) {
            array.add(child.name);
            if (child.children.size()!=0){
                for (Node childTmp : child.children){
                    doDepthFirstSearch(childTmp, array);
                }
            }else{
                return array;
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
