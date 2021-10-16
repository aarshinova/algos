public class NumberWaysGraph {
    public static void main(String[] args) {
        int rs = numberOfWaysToTraverseGraph(4,3);
        System.out.println("Results is " + rs);
    }

    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] numberWays = new int[width+1][height+1];

        for (int i=1; i<=width;i++){
            for (int j=1; j<=height;j++){
                if (i==1 || j==1){
                    numberWays[i][j] = 1;
                }
                else {
                    numberWays[i][j] = numberWays[i-1][j] + numberWays[i][j-1];
                }
            }
        }

        return numberWays[width][height];
    }
    }

