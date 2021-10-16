import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumCoinsChange {
    public static void main(String[] args) {
        int[] denoms = new int[]{3,5};
        int rs = minNumberOfCoinsForChange(9, denoms);
        System.out.println("Results is " + rs);
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int [] nbCoins = new int[n+1];
        nbCoins[0] = 0;

        for (int denom : denoms){
            for (int amount = 1; amount<=n; amount++){
                if (denom>amount) {
                    continue;
                }
                if (amount==denom) {
                    nbCoins[amount]=1;
                }
                else if (nbCoins[amount]==0) {
                    if (nbCoins[amount-denom]!=0){
                        nbCoins[amount] = nbCoins[amount-denom] + 1;
                    }
                }else {
                    if ((nbCoins[amount-denom]!=0))
                    nbCoins[amount] = Math.min(nbCoins[amount-denom]+1, nbCoins[amount]);
                }
            }
        }
        if (nbCoins[n]==0)
            return -1;
        else
            return nbCoins[n];
    }



}
