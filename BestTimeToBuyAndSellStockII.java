package arrays;

public class BestTimeToBuyAndSellStockII {
	/*
	 * Q: Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you 
	 * like (i.e., buy one and sell one share of the stock multiple times).
	 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the 
	 * stock before you buy again).
	 * */
	
	/*
	 * Algorithm:TotalProfit=∑i(height(peaki)−height(valleyi))
	 * 
	 * Complexity Analysis:
	 * T: O(n)
	 * S: O(1)
	 * */
	public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            max += Math.max(prices[i] - prices[i-1], 0);
        }
        return max;
    }
}
