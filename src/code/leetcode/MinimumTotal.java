package code.leetcode;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 * 
 * https://www.nowcoder.com/practice/2b7995aa4f7949d99674d975489cb7da?tpId=46&tqId=29060&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class MinimumTotal {
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null) {
			return 0;
		}
		int n = triangle.size();
		int[] sum = new int[n + 1];
		for (int i = n - 1; i >= 0; --i) {
			ArrayList<Integer> row = triangle.get(i);
			for (int j = 0; j <= i; ++j) {
				if (sum[j] < sum[j + 1]) {
					sum[j] = row.get(j) + sum[j];
				} else {
					sum[j] = row.get(j) + sum[j + 1];
				}
			}
		}
		return sum[0];
	}
}
