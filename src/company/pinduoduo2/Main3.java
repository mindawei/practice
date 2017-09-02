package company.pinduoduo2;

import java.util.Scanner;

public class Main3 {
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
		return 0;
	}
}
