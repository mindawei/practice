package code_offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=2&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=3
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FindNumbersWithSum {
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

		ArrayList<Integer> ls = new ArrayList<>();
		if (array == null || array.length <= 1) {
			return ls;
		}

		int p0 = 0;
		int p1 = array.length - 1;
		int s;
		while (p0 < p1) {
			s = array[p0] + array[p1];
			if (s == sum) {
				ls.add(array[p0]);
				ls.add(array[p1]);
				break;
			} else if (s > sum) {
				--p1;
			} else {
				++p0;
			}
		}

		return ls;
	}
}
