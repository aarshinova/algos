import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//In share trading, a buyer buys shares and sells on a future date. Given the stock price of n days, the trader is allowed to make at most k transactions,
//where a new transaction can only start after the previous transaction is complete, find out the maximum profit that a share trader could have made.
public class maxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{5, 11, 3, 50, 60, 90};
        int k = 2;

        // System.out.println("Result max profit : " + findMaxProfit(prices, k));

//        prices = new int[]{3, 2, 5, 7, 1, 3, 7};
//        k = 1;
//        System.out.println("Result max profit 2: " + findMaxProfit(prices, k));

        prices = new int[]{100, 99, 98, 97, 1};
        k = 5;
        System.out.println("Result max profit 2: " + findMaxProfit(prices, k));

        prices = new int[]{1, 25, 24, 23, 12, 36, 14, 40, 31, 41, 5};
        k = 2;
        System.out.println("Result max profit : " + findMaxProfit(prices, k));

//        35 -> 1 and 36
//            14 and 41
    }

    private static int findMaxProfit(int[] prices, int k) {
        if (prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int maxProfit = 0;

        //init
        for (int i: buy){
            buy[i] = -1;
        }
        for (int j:sell){
            sell[j] = -1;
        }

        int indSell = 0;
        int indBuy = 0;
        buy[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int todayPrice = prices[i];
            if (todayPrice < buy[indBuy] && indBuy == indSell) {
                buy[indBuy] = todayPrice;
            } else if (todayPrice > buy[indBuy] && indBuy == indSell) {
                indBuy++;
                sell[indSell] = todayPrice;
            } else if ((todayPrice < sell[indSell]) && indBuy != indSell) {
                indSell++;
                buy[indBuy] = todayPrice;
            } else if (todayPrice > sell[indSell] && indBuy != indSell) {
                sell[indSell] = todayPrice;
            } else if ((i == prices.length - 1) && sell[indSell] < prices[prices.length - 1] && indBuy != indSell) {
                sell[indSell] = todayPrice;
                indSell++;
            }

        }

        int ind = 0;
        ArrayList<Integer> maxProfitArr = new ArrayList<>();
        while (ind<buy.length && buy[ind] != -1 && sell[ind] != -1) {
            maxProfitArr.add(sell[ind] - buy[ind]);
            ind++;
        }


        Collections.sort(maxProfitArr, Collections.reverseOrder());

        for (int i:maxProfitArr){
            if (k==0)break;
            maxProfit+=i;
            k--;
        }

        return maxProfit;
    }
}