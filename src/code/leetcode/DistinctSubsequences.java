package code.leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 * 
 * 题意：给定两个字符串S和T，返回S中有多少个子序列和T一样。
 * 
 * https://www.nowcoder.com/practice/ed2923e49d3d495f8321aa46ade9f873?tpId=46&tqId=29065&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月14日
 */
public class DistinctSubsequences {
	
	public static void main(String[] args) {
		int v =new DistinctSubsequences().numDistinct("rabbbit", "rabbit");
		System.out.println(v);
	}
	
	public int numDistinct(String S, String T) {
		
		if(S==null||T==null){
			return 0;
		}
		
		int n = S.length();
		int m = T.length();
		
		if(n<m){
			return 0;
		}

		int[][] dp = new int[n+1][m+1];
		
		for(int i=0;i<=n;++i){
			dp[i][0] = 1;
		}
		
		for(int i=1;i<=n;++i){
			for(int j=1;j<=m;++j){
				if(S.charAt(i-1)==T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j]; 
				}
			}
		}

		return dp[n][m];
	}
	
}
