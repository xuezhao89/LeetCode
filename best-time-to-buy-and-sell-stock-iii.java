/*
题目：
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

思路：
创建一个数组left记录从左到右只能交易一次的最大收益，和一个数组right记录从右到左只能交易一次的最大收益，最后找出left+right组合的最大值。
left数组里需要定义变量min，通过比较当天价格和min更新min，再通过比较前天最大收益left[i - 1]和（当天价格-min）更新left[i]；right数组需要定义变量max，通过比较当天价格和max更新max，再通过比较后天收益right[i + 1]和（max-当天价格）更新right[i]。

注意：
left[0]和right[right.length - 1]初始值设为0，因为第一天是没有收益的。
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int profit = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        // 计算左半段的最大收益
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < left.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        // 计算右半段的最大收益
        right[right.length - 1] = 0;
        int max = prices[prices.length - 1];
	int profit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
		// 找出最大的收益组合
		profit = Math.max(profit, left[i] + right[i]);
        }
        
        return profit;
    }
}

