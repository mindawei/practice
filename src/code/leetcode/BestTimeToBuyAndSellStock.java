package code.leetcode;

/**
 * Say you have an array for which the i th element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=46&tqId=29059&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月14日
 */
public class BestTimeToBuyAndSellStock {
	
    public int maxProfit(int[] prices) {
    	
    	if(prices==null||prices.length<2){
    		return 0;
    	}
    	
    	int maxProfit = 0;
    	int minBuy = prices[0];
    	
    	for(int i=1;i<prices.length;++i){
    		if(prices[i]>minBuy){
    			maxProfit = Math.max(maxProfit, prices[i]-minBuy);
    		}else{
    			minBuy = prices[i];
    		}
    	}
    	
        return maxProfit;
    }
    
}
