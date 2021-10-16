import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Node graph = new Node("A");
        graph.addChild("B").addChild("C").addChild("D");
        graph.children.get(0).addChild("E").addChild("F");
        graph.children.get(2).addChild("G").addChild("H");
        graph.children.get(0).children.get(1).addChild("I").addChild("J");
        graph.children.get(2).children.get(0).addChild("K");
        String[] expected = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        List<String> inputArray = new ArrayList<>();
        List<String> res = graph.breadthFirstSearch(inputArray);
        System.out.println("Res " + res);
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);
                queue.addAll(node.children);
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

