import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * Given an array of prices where prices[i] is the price of a given
 * stock on the i^th day.
 *
 * Aim: Maximize your profit by choosing a single day to buy one
 * stock and choosing a different day in future to sell that stock.
 *
 * Aim: Return the maximum profit you can achieve from this transaction.
 * If you can not achieve any profit return 0.
 *
 *
 * Example1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 *
 *
 * Example2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 */


public class BestTimeToBuyAndSellStock {

    //O(n)
    public int maxProfit(int[] prices) {
        int result = 0;
        int currentElement = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i]<currentElement) {
                currentElement = prices[i];
            } else {
                result = Math.max(result, prices[i] - currentElement);
            }
        }
        return result;
    }

}
