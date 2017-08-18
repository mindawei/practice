package company.netease;


/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。
 * 学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。
 * 由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。
 * 现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 * 
 * https://www.nowcoder.com/profile/707331/test/9835951/112729#summary
 * 
 * @author mindw
 * @date 2017年8月18日
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;++i){
			arr[i] = sc.nextInt();
		}
		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {
		Arrays.sort(arr);
		
		int min = arr[0];
		int max = arr[arr.length-1];
		int sum = max - min;
		
		int i =1,j = arr.length-2;
		while(i<=j){
			sum += arr[j] - min;
			sum += max - arr[i];
			
			min = arr[i++];
			max = arr[j--];
		}
		return sum;
	}
}
