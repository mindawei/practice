package company.pinduoduo;


/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，
 * 他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * 
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int[] h = new int[sc.nextInt()];
		for(int i=0;i<h.length;++i){
			h[i] = sc.nextInt();
		}
		
		int[] w = new int[sc.nextInt()];
		for(int i=0;i<w.length;++i){
			w[i] = sc.nextInt();
		}
		
		System.out.println(solve(h,w));
	}

	private static int solve(int[] h, int[] w) {
		
		Arrays.sort(h);
		Arrays.sort(w);
		
		int ans = 0;
		int i = w.length -1;
		int j = h.length -1;
		while(i>=0&&j>=0){
			if(w[i]>=h[j]){
				++ans;
				--i;
			}
			--j;
		}
		return ans;
	}
}
