import java.util.Arrays;

class NonConstructibleChange {

    public static void main(String[] args) {
        int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};
        boolean fastest = true;
        var output = nonConstructibleChange(coins);
        System.out.print(output);

    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int sum = 0;
        for (int i=0; i<coins.length; i++){
            if (coins[i]>sum+1) {
                return sum+1;
            }
            else {
                sum = sum  + coins[i];
            }
        }
        return -1;
    }
}
