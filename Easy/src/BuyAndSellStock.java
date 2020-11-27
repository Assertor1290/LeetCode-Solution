/**
 * <p>
 *     Say you have an array for which the ith element is the price of a given stock on day i.
 *     If you were only permitted to complete at most one transaction
 *     (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 *     Note that you cannot sell a stock before you buy one.
 * </p>
 */
public class BuyAndSellStock {
    /**
     * Brute force
     * TC: O(n^2) SC:O(1)
     * @param prices input array
     * @return maxProfit
     */
    public int maxProfit(int[] prices){
        int maxProfit=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int profit=prices[j]-prices[i];
                if(profit>maxProfit)
                    maxProfit=profit;
            }
        }
        return maxProfit;
    }

    /**
     * One pass
     * TC:O(n) SC:O(1)
     * @param prices input array
     * @return maxProfit
     */
    public int maxProfit2(int[] prices){
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prices=new int[]{7,1,5,3,6,4};
        System.out.println(new BuyAndSellStock().maxProfit(prices));
        System.out.println(new BuyAndSellStock().maxProfit2(prices));
    }
}
