package code.leetcode;

/**
 *  A message containing letters fromA-Zis being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).
 * The number of ways decoding"12"is 2.
 * 
 * https://www.nowcoder.com/practice/a2539eb0a9ec4c54a055091e706072cc?tpId=46&tqId=29088&tPage=3&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月15日
 */
public class NumDecodings {

    public int numDecodings(String s) {
    	if(s==null){
    		return 0;
    	}
    	
    	int n = s.length();
    	if(n==0 || s.charAt(0)=='0'){
        	return 0;
        }
    	
    	int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
		for (int i = 2; i <= n; ++i) {
			if(s.charAt(i-1)=='0'){
				if(s.charAt(i-2)=='1'||s.charAt(i-2)=='2'){
					dp[i] = dp[i - 2];
				}else{
					return 0;
				}
			}else{
				dp[i] = dp[i - 1];
				if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
					dp[i] += dp[i - 2];
				}
			}
		}
    	return dp[n];
    }
}
