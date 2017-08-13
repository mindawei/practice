package code.leetcode;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * https://www.nowcoder.com/practice/81d7738f954242e5ade5e65ec40e5027?tpId=46&tqId=29106&tPage=4&rp=4&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月13日
 * @Description
 */
public class EditDistance {
	
	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("sea","ate"));
	}
	
	 public int minDistance(String word1, String word2) {
		 int n = word1.length();
		 int m = word2.length();
		 int[][] f = new int[n+1][m+1];
		 
		 int inf = n + m;
		 for(int i=0;i<=n;++i){
			 f[i][0]=i; 
		 }
		 for(int i=0;i<=m;++i){
			 f[0][i]=i; 
		 }
		 
		 for(int i=1;i<=n;++i){
			 for(int j=1;j<=m;++j){
				 f[i][j] = inf;
				 f[i][j] = Math.min(f[i][j], f[i-1][j]+1); // delete
				 f[i][j] = Math.min(f[i][j], f[i-1][j-1]+1); // insert  
				 f[i][j] = Math.min(f[i][j], f[i][j-1]+1); // update  
				 if(word1.charAt(i-1)==word2.charAt(j-1)){
					 f[i][j] = Math.min(f[i][j], f[i-1][j-1]); // update  
				 }
			 }
		 }
		 
		 return f[n][m];
	 }
}
