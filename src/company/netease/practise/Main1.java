package company.netease.practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 划分两个数组使得差尽量小
 * 0,1背包问题的变化
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;++i){
			arr[i] = sc.nextInt() / 1024;
		}
		System.out.println(solve(arr)*1024);
	}

	private static int solve(int[] arr) {
		
		int sum = 0;
		for(int val : arr){
			sum +=val;
		}
		int v=sum>>1;
		int n = arr.length;
		int[] f = new int[v+1];
		Arrays.fill(f, v);
		
		for(int i=0;i<n;++i){
			for(int j=v;j>=arr[i];--j){
				if(f[j-arr[i]] - arr[i]>=0){
					f[j] = Math.min(f[j-arr[i]] - arr[i], f[j]);
				}
			}
		}
		
		return (sum - v) + f[v];
	}
}
