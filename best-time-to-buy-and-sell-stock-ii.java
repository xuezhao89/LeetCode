/*
题目：
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

思路：
定义变量diff=当天价格与前一天价格之差，如果diff>0则加入profit
*/

public int maxProfit(int[] prices) {
	// write your code here
	int profit = 0;
	for (int i = 1; i < prices.length; i++) {
		int diff = prices[i] - prices[i - 1];
		if (diff > 0) {
			profit += diff;
		}
	}
	return profit;
    }
}