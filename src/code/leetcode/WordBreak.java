package code.leetcode;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s ="leetcode", dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 * 
 * https://www.nowcoder.com/practice/5f3b7bf611764c8ba7868f3ed40d6b2c?tpId=46&tqId=29041&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月5日
 * @Description
 */
public class WordBreak {
	
	public boolean wordBreak(String s, Set<String> dict) {

		if (s == null || dict == null) {
			return false;
		}

		if (s.length() == 0) {
			return dict.contains("");
		}

		int n = s.length();
		boolean[] isOK = new boolean[n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (isOK[j] && dict.contains(s.substring(j + 1, i+1))) {
					isOK[i] = true;
					break;
				}
			}
			
			if(!isOK[i]){
				isOK[i] = dict.contains(s.substring(0,i+1));
			}
		}
		
		return isOK[n-1];
	}
}
