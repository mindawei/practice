package code.leetcode;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * https://www.nowcoder.com/practice/572903b1edbd4a33b2716f7649b4ffd4?tpId=46&tqId=29058&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月14日
 */
public class BestTimeToBuyAndSellStockII {
	public int maxProfit(int[] prices) {
		if(prices==null){
			return 0;
		}
		
		int profit = 0;
		for(int i=1;i<prices.length;++i){
			if(prices[i]>prices[i-1]){
				profit += prices[i] - prices[i-1];
			}
		}
		
		return profit;
	}
}
