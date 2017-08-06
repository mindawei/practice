package code.leetcode;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * https://www.nowcoder.com/practice/74a62e876ec341de8ab5c8662e866aef?tpId=46&tqId=29045&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class Candy {
	
	public int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0) {
			return 0;
		}

		int n = ratings.length;
		int[] nums = new int[n];
		nums[0] = 1;
		int sum = 1;
		for(int i=1;i<n;++i){
			if(ratings[i-1] == ratings[i]){
				nums[i] = 1;
			}else if(ratings[i-1] > ratings[i]){
				nums[i] = 1;
				int j = i;
				while (j >= 1 && (ratings[j - 1] > ratings[j] && nums[j - 1] == nums[j])) {
					++sum;
					++nums[j - 1];
					--j;
				}
			}else{ //  ratings[i-1] < ratings[i]
				nums[i] = nums[i-1] + 1;
			}
			
			sum += nums[i];
		}
		
		return sum;
	}
	
}
