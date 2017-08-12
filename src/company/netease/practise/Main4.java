package company.netease.practise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class Main4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] num = new int[n];
		
		for(int i=0;i<n;++i){
			num[i] = sc.nextInt();
		}
		
		boolean[] nums = new boolean[1001];
		ArrayList<Integer> ls = new ArrayList<>();
		for(int i=n-1;i>=0;--i){
			int v = num[i];
			if(!nums[v]){
				ls.add(v);
				nums[v]= true;
			}
		}
		
		for(int i=ls.size()-1;i>=0;--i){
			System.out.print(ls.get(i));
			if(i!=0){
				System.out.print(' ');
			}
		}
	
		System.out.println();
	}
	
}
