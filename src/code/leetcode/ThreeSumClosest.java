package code.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * 
 * https://www.nowcoder.com/practice/291a866d7c904563876b373b0b157dde?tpId=46&tqId=29162&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=7
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class ThreeSumClosest {
   
	public int threeSumClosest(int[] num, int target) {
		
		if (num == null) {
			return 0;
		}
		
		Arrays.sort(num);
		
		int ans = 0;
		int minDist = Integer.MAX_VALUE;

		for(int i=0;i<num.length-2;++i){
			if(i-1>=0 && num[i]==num[i-1]){
				continue;
			}
			
			int j = i+1;
			int k = num.length -1;
			while(j<k){
				int sum = num[i]+num[j]+num[k];
				if(sum==target){
                   return sum;
				}else if(sum<target){
                    ++j;
                }else{
                    --k;
                }
				
				int dist = Math.abs(sum-target);
				if(dist<minDist){
					minDist = dist;
					ans = sum;
				}
				
			}
			
		}
		
		
        return ans;
    }

}
