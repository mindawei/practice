package company.netease.practise;

import java.util.Scanner;

/**
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
 * GGBBG -> GGBGB -> GGGBB
 * 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次 
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class Main3 {

	// 答案参考： https://www.nowcoder.com/discuss/22696?type=0&order=0&pos=8&page=1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str =sc.next();
		System.out.println(solve(str));
	}

	private static int solve(String str) {	
		return Math.min(getSwapNum(str.toCharArray(), 'G', 'B'), getSwapNum(str.toCharArray(), 'B', 'G'));
	}
	
	private static int getSwapNum(char[] chs,char leftTag,char rightTag){
		int num = 0;
		int i =0;
		while(i<chs.length){
			if(chs[i]==rightTag){
				int j = i+1;
				while(j<chs.length && chs[j]==rightTag){
					++j;
				}
				if(j==chs.length){
					break;
				}else{
					chs[j] = rightTag; 
					num += j - i;
				}
				
			}
			++i;
		}
		return num;
	}
	
	
}
