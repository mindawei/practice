package company.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * 只通过80%
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */
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
		
		int len = Math.min(h.length, w.length);
		
		minTopK(h,0,h.length-1,len);
		minTopK(w,0,w.length-1,len);
		
		Arrays.sort(h,0,len);
		Arrays.sort(w,0,len);
		
		int n = h.length;
		int ans = 0;
		int j = n - 1;
		for (int i = w.length - 1; i >= 0; --i)
		{
			for (; j >= 0; --j)
			{
				if (w[i] >= h[j]){
					++ans;
					break;
				}
			}
		}
	
		return ans;
	}
	
	
	private static void minTopK(int[] arr, int bg, int ed, int k) {
		if(bg<ed){
			int pos = minPartion(arr,bg,ed);
			if (pos == k) {
				return;
			} else if (k > pos) {
				minTopK(arr, pos + 1, ed, k - pos);
			}else{ // k < pos
				minTopK(arr,bg,pos-1,k);
			}
		}
	}

	private static int minPartion(int[] arr, int i, int j) {
		int val = arr[i];
		while(i<j){
			while(i<j&&arr[j]>=val){
				--j;
			}
			arr[i] = arr[j];
			while(i<j&&arr[i]<=val){
				++i;
			}
			arr[j] = arr[i];
		}
		arr[i] = val;
		return i;
	}
	
	
	


}
