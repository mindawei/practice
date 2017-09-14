package company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] v = new long[n];
		
		int[] mods = new int[7];
		for(int i=0;i<n;++i) {
			int num  = sc.nextInt();
			v[i] = num;
			mods[num%7]++;
		}
		
		int ans = 0;
		for(int i=0;i<n;++i) {
			
			long num = v[i];
			int ys = (int)(num % 7);
			
			if(ys==0) {
				ans+=n-1;
			}else {
				
				long base = 1;
				long left = num;
				while(left>0) {
					left/=10;
					base *=10;
				}
				
				for(int j=1;j<7;++j) {
					if((base*j+num) % 7==0) {
					     if(ys==j) {
					    	 ans += mods[j]-1;
					     }else {
					    	 ans += mods[j];
					     }
					}
				}
			}
			
		}
		
		System.out.println(ans);
	}
}