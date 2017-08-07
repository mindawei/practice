package code.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 * 
 * https://www.nowcoder.com/practice/57d83a2501164168841c158a7535b458?tpId=46&tqId=29052&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月7日
 */
public class LongestConsecutive {
	
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<>();
		for(int v : num){
			set.add(v);
		}
		
		int maxLen = 0;
		int left,right;
		for(int v : num){
			left = v;
			right = v+1;
			while(set.contains(left)){
				set.remove(left);
				--left;
			}
			
			while(set.contains(right)){
				set.remove(right);
				++right;
			}
			
			maxLen = Math.max(maxLen, right-left-1);
		}
		
		return maxLen;
	}
}
