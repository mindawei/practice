package company.netease;

import java.util.Scanner;

public class Main3 {

	// 40%
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n,k));
	}

	
	private static int solve(int n,int k) {
		int[][] f = new int[n+1][k+1];
		
	
		for (int i = 1; i <= k; ++i) {
			for (int j = 1; j <= i; ++j) {
				for (int m = 1; m <= i; ++m) {
					if (m <= j || m % j != 0) {
						++f[2][i];
						if(f[2][i]>=1_000_000_007){
							f[2][i] %= 1_000_000_007;
						}
					}
				}
			}
		}
	
		for(int r=3;r<=n;++r){
			for(int j=1;j<=k;++j){
				for(int m=1;m<=k;++m){
					if(m<=j||m%j!=0){
						f[r][j] += f[r-1][m];
						if(f[r][j]>=1_000_000_007){
							f[r][j] %= 1_000_000_007;
						}
					}
				}
			}
			
		}
		
		return f[n][k];
	}
	

}