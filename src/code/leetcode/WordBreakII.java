package code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given s ="catsanddog", dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 * 
 * https://www.nowcoder.com/practice/bd73f6b52fdc421d91b14f9c909f9104?tpId=46&tqId=29040&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=1
 * 
 * @author 闵大为
 * @data 2017年8月5日
 * @Description
 */
public class WordBreakII {
	
	public static void main(String[] args) {
		
				String s = "aaaaaaa";
				Set<String> dict = new HashSet<>();
				dict.add("aaaa");
				dict.add("aaa");
				
				System.out.println(new WordBreakII().wordBreak(s, dict));
				
				
	}

	    public ArrayList<String> wordBreak(String s, Set<String> dict) {
	             
	           if (s == null || dict == null) {
	                return new ArrayList<>();
	            }
	 
	           	Map<String,ArrayList<String>> map = new HashMap<>();
	            return DFS(s,dict,map);
	   }

		private ArrayList<String> DFS(String s, Set<String> dict, Map<String, ArrayList<String>> map) {
			
			if(map.containsKey(s)){
				return map.get(s);
			}
			
			ArrayList<String> ans = new ArrayList<>();
	
			for(String pre : dict){
				
				if(s.startsWith(pre)){
					if(pre.length()==s.length()){
						ans.add(pre);		
					}else{
						ArrayList<String>  subList =  DFS(s.substring(pre.length()),dict,map);
						for(String str : subList){
							ans.add(pre+" "+str);		
						}		
					}
				}
			}
		
			map.put(s, ans);
			return ans;
		}
	
}
