package code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=46&tqId=29163&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=7
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class ThreeSum {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
		for(ArrayList<Integer> ls : ans){
			System.out.println(ls);
		}
	}

	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		if (num == null) {
			return ans;
		}
		
		Arrays.sort(num);

		for(int i=0;i<num.length-2;++i){
			if(i-1>=0 && num[i]==num[i-1]){
				continue;
			}
			
			int j = i+1;
			int k = num.length -1;
			while(j<k){
			
				if(num[i]+num[j]+num[k]==0){
					
					ArrayList<Integer> ls = new ArrayList<Integer>();
					ls.add(num[i]);
					ls.add(num[j]);
					ls.add(num[k]);
                    ans.add(ls);
                    
                    ++j;
                    --k;
                    
					while(j<k&&num[j]==num[j-1]){
						++j;
					}
				
					while(j<k&&num[k]==num[k+1]){
						--k;
					}
                    
				}else if(num[i]+num[j]+num[k]<0){
                    ++j;
                }else{
                    --k;
                }
			}
			
		}
		
		return ans;
	
	}
	
}
