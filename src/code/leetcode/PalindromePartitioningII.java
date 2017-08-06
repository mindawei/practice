package code.leetcode;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 * 
 * https://www.nowcoder.com/practice/1025ffc2939547e39e8a38a955de1dd3?tpId=46&tqId=29048&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class PalindromePartitioningII {
	 public int minCut(String s) {
	  
		 if(s==null||s.length()<=1){
			 return 0;
		 }
		 
		 char[] chs = s.toCharArray();
		 int inf = 100000000;
		 int[] minCuts = new int[chs.length];
		 Arrays.fill(minCuts, inf);
		 
		 for(int i=0;i<chs.length;++i){
			 if(isPalindrome(chs, 0, i)){
				 minCuts[i] = 0;
			 }else{
				 for(int j=0;j<chs.length;++j){
					 if(isPalindrome(chs, j+1, i)){
						 minCuts[i] = Math.min(minCuts[i], minCuts[j]+1);
					 }
				 }
			 }			 
		 }

		 return minCuts[chs.length-1];
	 }
	 
	 private boolean isPalindrome(char[] chs,int left,int right){
		 while(left<right && chs[left]==chs[right]){
			++left;
			--right;
		 }
		 return left>=right;
	 }
}
