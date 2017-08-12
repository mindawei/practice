package company.netease.practise;

import java.util.Scanner;

/**
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。 
 * 输入描述:
 * 输入数据包括两行：
 * 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 * 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 * 
 * 
 * 
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class Main5 {
	// 只通过 60% 用个矩阵快速幂,边算边求模。
	// 答案参考： https://www.nowcoder.com/discuss/22696?type=0&order=0&pos=8&page=1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;++i){
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<k;++i){
			int tmp = (arr[n-1] + arr[0]);
			if(tmp>=100){
				tmp -= 100;
			}
			for(int j=0;j<n-1;++j){
				if((arr[j] = arr[j] + arr[j+1])>=100){
					arr[j]-=100;
				}
			}
			arr[n-1] = tmp;
		}
		
		for(int i=0;i<n;++i){
			System.out.print(arr[i]);
			if(i==n-1){
				System.out.println();
			}else{
				System.out.print(" ");
			}
		}
	}
}
