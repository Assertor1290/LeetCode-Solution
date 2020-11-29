/**
 * <p>
 *  Say you have an array prices for which the ith element
 *  is the price of a given stock on day i.
 *
 *  Design an algorithm to find the maximum profit.
 *  You may complete as many transactions as you like
 *  (i.e., buy one and sell one share of the stock multiple times).
 *
 *  Note: You may not engage in multiple transactions at the same time
 *  (i.e., you must sell the stock before you buy again).
 * </p>
 */
public class BuyAndSellStockTwo {
    /**
     * Method 1: Peak Valley Approach
     * The key point is we need to consider every peak
     * immediately following a valley to maximize the profit.
     * TC:O(n) SC:O(1)
     * @param prices input array
     * @return maxProfit
     */
    public int maxProfit(int[] prices){
        int i=0;
        int maxProfit=0;
        int peak=prices[0];
        int valley=prices[0];
        while(i<prices.length-1){
            while (i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            valley=prices[i];
            while (i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            peak=prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }

    /**
     * Method 2: One pass
     * we can directly keep on adding the difference between the consecutive
     * numbers of the array if the second number is larger than the first one,
     * and at the total sum we obtain will be the maximum profit.
     * TC:O(n) SC:O(1)
     * @param prices input array
     * @return maxProfit
     */
    public int maxProfit2(int[] prices){
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                maxProfit+=prices[i]-prices[i-1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices=new int[]{1,7,2,3,6,7,6,7};
        System.out.println(new BuyAndSellStockTwo().maxProfit(prices));
        System.out.println(new BuyAndSellStockTwo().maxProfit2(prices));
    }
}
