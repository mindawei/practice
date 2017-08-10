package code.leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 *
 * https://www.nowcoder.com/practice/4d0f94617e454e2da23e660cded4d9e8?tpId=46&tqId=29081&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月10日
 */
public class IsInterleave {
	
	// f[k][m][n] = ..
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1==null||s2==null||s3==null){
			return false;
		}
		if(s1.length()+s2.length()!=s3.length()){
			return false;
		}
		return walk(s1,0,s2,0,s3,0);
	}
	
	// 超时
//	public boolean isInterleave(String s1, String s2, String s3) {
//		if(s1==null||s2==null||s3==null){
//			return false;
//		}
//		if(s1.length()+s2.length()!=s3.length()){
//			return false;
//		}
//		return walk(s1,0,s2,0,s3,0);
//	}
//	private boolean walk(String s1, int i,String s2, int j, String s3, int k) {
//		if(i==s1.length()&&j==s2.length()&&k==s3.length()){
//			return true;
//		}else if(k==s3.length()){
//			return false;
//		}
//		
//		if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)&&walk(s1, i+1, s2, j, s3, k+1)){
//			return true;
//		}
//		
//		if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)&&walk(s1, i, s2, j+1, s3, k+1)){
//			return true;
//		}
//		
//		return false;
//	}
}
