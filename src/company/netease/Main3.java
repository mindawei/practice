package company.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

	// 40%
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n,k));
	}

	private static final int mod = 1_000_000_007;
	
	private static int solve(int n,int k) {
		int[][] f = new int[n+1][k+1];
		Arrays.fill(f[1], 1);
		for(int i=2;i<=n;++i){
			int sum = 0;
			for(int j=1;j<=k;++j){
				sum += f[i-1][j];
				sum %= mod;
			}
			for(int j=1;j<=k;++j){
				int sum2 = 0;
				for(int z=j+j;z<=k;z+=j){
					sum2 += f[i-1][z];
					sum2 %= mod;
				}
				
				f[i][j] =(sum  - sum2 + mod)%mod;
				
			}
		}
		
		int ans = 0;
		for(int i=1;i<=k;++i){
			ans += f[n][i];
			ans %= mod;
		}
	
		return ans;
	}
	

}