package company.meituan;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;++i){
			int v = sc.nextInt();
			sum += v;
			max = Math.max(v, max);
		}
		
		if(n>1 && max <= (sum - max)){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
	}
}
