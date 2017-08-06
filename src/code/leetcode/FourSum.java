package code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * 
 * https://www.nowcoder.com/practice/eb632e81417c4d5797cd712b82f7daa1?tpId=46&tqId=29161&tPage=7&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		if (num == null) {
			return ans;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; ++i) {
			
			if (i - 1 >= 0 && num[i] == num[i - 1]) {
				continue;
			}

			int j = i + 1;
			while (j < num.length) {

				int k = j + 1;
				int m = num.length - 1;
				while (k < m) {

					int sum = num[i] + num[j] + num[k] + num[m];
					if (sum == target) {

						ArrayList<Integer> ls = new ArrayList<Integer>();
						ls.add(num[i]);
						ls.add(num[j]);
						ls.add(num[k]);
						ls.add(num[m]);
						ans.add(ls);

						++k;
						--m;

						while (k < m && num[k] == num[k - 1]) {
							++k;
						}

						while (k < m && num[m] == num[m + 1]) {
							--m;
						}

					} else if (sum < target) {
						++k;
					} else {
						--m;
					}
				}

				++j;
				while (j < num.length && num[j] == num[j - 1]) {
					++j;
				}

			}

		}
		return ans;
	}
}
