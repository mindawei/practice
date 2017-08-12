package company.netease.practise;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] xs = new int[n];
		int[] ys = new int[n];
		for(int i=0;i<n;++i){
			xs[i] = sc.nextInt();
		}
		for(int i=0;i<n;++i){
			ys[i] = sc.nextInt();
		}
		
		int tx = sc.nextInt();
		int ty = sc.nextInt();
		
		int walkTime = sc.nextInt();
		int taxiTime = sc.nextInt();
		
		int minT = (Math.abs(tx)+Math.abs(ty))*walkTime;
		for(int i=0;i<n;++i){
			int t = (Math.abs(xs[i])+Math.abs(ys[i]))*walkTime
					+(Math.abs(xs[i]-tx)+Math.abs(ys[i]-ty))*taxiTime;
			minT = Math.min(minT, t);
		}
		
		System.out.println(minT);
	}
	
}
