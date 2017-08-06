package code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s ="aab",Return
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * 
 * https://www.nowcoder.com/practice/f983806a2ecb4106a17a365a642a9632?tpId=46&tqId=29049&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=1
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class PalindromePartitioning {
	
	 /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
//        // write your code here
//    }
//    
//	public ArrayList<ArrayList<String>> partition(String s) {
		if(s==null||s.length()==0){
			return  new ArrayList<>();
		}
		
		Map<String,List<List<String>>> map = new HashMap<>();
		return DFS(s,s.toCharArray(),map,s.length()-1);
    }

	private List<List<String>> DFS(String s,char[] chs, Map<String, List<List<String>>> map, int right) {

		String str = new String(chs,0,right+1);
		
		if(map.containsKey(str)){
			return map.get(str);
		}
		
		List<List<String>> ans = new ArrayList<>();
		
		if(isPalindrome(chs, 0, right)){
			ArrayList<String> ls = new ArrayList<>();
			ls.add(str);
			ans.add(ls);
		}
		
		for (int i = 0; i <right; ++i) {
			if (isPalindrome(chs, i + 1, right)) {
				String rightStr = s.substring(i + 1, right + 1);
				List<List<String>> leftList = DFS(s, chs, map, i);
				for (List<String> leftLs : leftList) {
					List<String> ls = new ArrayList<>(leftLs);
					ls.add(rightStr);
					ans.add(ls);
				}

			}
		}
		
		map.put(str, ans);
		return ans;
		
	}

	private boolean isPalindrome(char[] chs,int left,int right){
		while(left<right && chs[left]==chs[right]){
			++left;
			--right;
		}
		return left>=right;
	}
	
}
