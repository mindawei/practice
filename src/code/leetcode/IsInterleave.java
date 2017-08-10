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
	
	public static void main(String[] args) {
		System.out.println(new IsInterleave().isInterleave("ba","ba","bbaa"));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1==null||s2==null||s3==null){
			return false;
		}
		
		int len3 = s3.length(),len2 = s2.length(),len1 = s1.length();
		
		if(len1==0){
			return s2.equals(s3);
		}else if(len2==0){
			return s1.equals(s3);
		}else if(len1+len2!=len3){
			return false;
		}

		final boolean[][] f = new boolean[len2+1][len1+1];
		f[0][0] = true;
		int i,j,k;
		for(i=1;i<=len3;++i){
			for(j = i < len2 ? i : len2;j>=0;--j){
				if((k = i-j) >len1){
					break;
				}
				if ((j > 0 && f[j - 1][k] && s3.charAt(i - 1) == s2.charAt(j - 1)
						|| (k > 0 && f[j][k - 1] && s3.charAt(i - 1) == s1.charAt(k - 1)))) {
					f[j][k] = true;
				}
			}
		}
		return f[len2][len1];
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
