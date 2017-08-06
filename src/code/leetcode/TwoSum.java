package code.leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=46&tqId=29177&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=8
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{ map.get(numbers[i]) + 1, i + 1};
            }
            map.put(target - numbers[i], i);
        }
        return null;
    }

}
