

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for(int i=0;i<n;++i){
			nums[i] = in.nextInt();
		}
		System.out.println(solves(nums));
//		in.close();
	}

	private static int solves(int[] nums) {
		int n =nums.length;
		if(n<3){
			return 0;
		}
		
		// sum -> index
		Map<Integer,List<Integer>> rightSum = new TreeMap<>();
		int sum = 0;
		List<Integer> ls;
		for(int i=n-1;i>=0;--i){
			sum += nums[i];  
			
			ls = rightSum.get(sum);
			if(ls==null){
				ls = new ArrayList<Integer>();
				rightSum.put(sum, ls);
			}
			ls.add(i);
		}
		
		int totalSum = sum;
		int num = 0;
		int sum0 = 0,sum1,sum2;
		
		for(int i=0;i<n-2;++i){
			sum0 += nums[i];  
			for(int j=-1;j<=1;++j){
				sum2 = sum0 + j;
				if((ls = rightSum.get(sum2))!=null){
					for(int index : ls){
						if(i+1>=index){
							break;
						}else{
							sum1 = totalSum - sum2 - sum0;
							if(Math.abs(sum1-sum2)<=1&&Math.abs(sum1-sum0)<=1){
								num++;
							}
						}
					}
				}
			}
		}
		return num;
	}
}
