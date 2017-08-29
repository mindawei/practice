package company.alibaba;

import java.util.Scanner;

/**
 * 
 * @author 闵大为
 * @data 2017年8月25日
 * @Description
 */
public class Solution3 {
	 // 10 4 5 12 8
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = in.nextInt();
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = in.nextInt();
        }
        System.out.println();
    }
}
