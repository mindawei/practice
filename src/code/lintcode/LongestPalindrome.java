package code.lintcode;

/**
 * 给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc"。
 * follow up: 问了类似于找出最长且长度为奇数／偶数的回文子串的这种问题。
 * http://www.lintcode.com/zh-cn/problem/longest-palindromic-substring/
 * http://www.jiuzhang.com/solutions/longest-palindromic-substring/
 * 
 * @author mindw
 * @date 2017年7月28日
 */
public class LongestPalindrome {
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("bb"));
	}
	
	/*
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if(s==null){
        	return null;
        }
        if(s.length()<=1){
        	return s;
        }
        
        char[] chs = s.toCharArray();
        
        int maxLen = 1;
        String ans = s.substring(0,1);
        String res = null;
        for(int i=0;i<chs.length-1;++i){
        	if((res= get(chs,i,i,maxLen))!=null){
        		ans = res;
        		maxLen = ans.length();
        	}
        	if((res= get(chs,i,i+1,maxLen))!=null){
        		ans = res;
        		maxLen = ans.length();
        	}
        }
    	return ans;
    }
    
    private String get(char[] chs,int i,int j, int maxLen) {
		
    	int bi = i;int bj = i;
    	while(i>=0 && j<chs.length && chs[i]==chs[j]){
    		bi = i;
    		bj = j;
    		--i;
    		++j;
    	}
    	
    	int len = bj - bi + 1;
    	if(len > maxLen){
    		return new String(chs, bi, len);
    	}else{
    		return null;
    	}
	}

}
