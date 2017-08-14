package code.leetcode;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * https://www.nowcoder.com/practice/03905f7b819241398b02ee39bef3e8f1?tpId=46&tqId=29057&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月14日
 */
public class BestTimeToBuyAndSellStockIII {
	
	public static void main(String[] args) {
		int v = new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1,2});
		System.out.println(v);
	}
	
	public int maxProfit(int[] prices) {
		
		if(prices==null||prices.length<=1){
			return 0;
		}
		
		int[] max0 = new int[prices.length];
		int min = prices[0];
		for(int i=1;i<prices.length;++i){
			max0[i] = Math.max(prices[i]-min,max0[i-1]);
			min = Math.min(min, prices[i]);
		}
		
		int[] max1 = new int[prices.length];
		int max = prices[prices.length-1];
		for(int i=prices.length-2;i>=0;--i){
			max1[i] = Math.max(max-prices[i],max1[i+1]);
			max = Math.max(max, prices[i]);
		}
		
		int maxProfit = Math.max(0, max0[prices.length-1]);
		for(int i=0;i<prices.length-1;++i){
			maxProfit =Math.max(maxProfit, max0[i]+max1[i+1]);
		}
		return maxProfit;
	}
}
