package company.pinduoduo;

import java.util.Scanner;

/**
 * 一个数组里面有正数、0、负数
 * 
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;++i){
        	arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }

	private static long solve(int[] arr) {

		long max1 = 0, max2 = 0, max3 = 0,min1=0,min2=0;
		for(int v : arr){
			if(v==0){
				continue;
			}else if(v>max1){
				max3 = max2;
				max2 = max1;
				max1 = v;
			}else if(v>max2){
				max3 = max2;
				max2 = v;
			}else if(v>max3){
				max3 = v;
			}else if(v<min1){
				min2 = min1;
				min1 = v;
			}else if(v<min2){
				min2 = v;
			}
		}

		return Math.max(max1*max2*max3,max1*min1*min2);
	}
}
