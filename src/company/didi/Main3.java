package company.didi;

import java.util.Scanner;

public class Main3 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  n = sc.nextInt();
		int[] num = new int[200000+1];
		int min = 1;
		for(int i=0;i<n;++i){
			int v = sc.nextInt();
			if(i>0){
				System.out.print(" ");
			}
			System.out.print(num[v]);
			for(int j=min;j<v;++j){
				++num[j];
			}
			if(v==i){
				
			}
		}
		System.out.println();
	}
}