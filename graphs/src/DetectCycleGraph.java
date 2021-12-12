import java.util.*;

public class DetectCycleGraph {
    public static boolean cycleDetected = false;
    static List<String> strings = new ArrayList<>();
    public static int numberVisited = 0;
    public static void main(String[] args) {
        int[][] input =
                new int[][]{
                        {1,2},
                        {2},
                        {}};
        boolean actual = cycleInGraph(input);
        System.out.println(actual);
    }

    public static boolean cycleInGraph(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] stack = new boolean[edges.length];
        for (int i=0; i<edges.length; i++){
            if (visited[i]==true){
               continue;
            }
            Boolean ifCycle = visitNext(i, edges, visited, stack);
            if (ifCycle){
                return true;
            }
        }
        return false;
    }

    private static boolean visitNext( int nodeToJump, int[][] input, boolean[] visited, boolean[] stack) {
       visited[nodeToJump] = true;
       stack[nodeToJump] = true;
       boolean isCycle = false;

       for (int i=0; i<input[nodeToJump].length; i++){
           int nextNode = input[nodeToJump][i];
           if (visited[nextNode]!=true){
               isCycle = visitNext(input[nodeToJump][i], input, visited, stack);
           }
           if (isCycle){
               return true;
           }
           if (stack[nextNode]==true){
               return true;
           }
       }

       stack[nodeToJump] = false;
       return false;

    }
}

