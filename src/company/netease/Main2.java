package company.netease;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		for(int i=0;i<n;++i){
			x[i] = sc.nextInt();
		}
		int[] y = new int[n];
		for(int i=0;i<n;++i){
			y[i] = sc.nextInt();
		}
		
		final int inf = 99999999;
		int[] res = new int[n];
		Arrays.fill(res,inf);
		
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {
	            for(int k = 0; k < n; k++) {
	                int[] res2 = new int[n];
	                for(int l = 0; l < n; l++) {
	                    res2[l] = Math.abs(x[l] - x[j]) + Math.abs(y[l] - y[k]);
	                }
	                Arrays.sort(res2);
	                int res3 = 0;
	                for(int l = 0; l < i + 1; l++) res3 += res2[l];
	                res[i] = Math.min(res[i], res3);
	            }
	        }
	    }
	    for(int i = 0; i < n; i++) {
	    		if(i==0){
	    				System.out.print(res[i]);
	    		}else{
	    				System.out.print(" "+res[i]);
	    		}
	       
	    }
	    System.out.println();
	}

//	private static int min = Integer.MAX_VALUE;
//
//	
//	private static int solve(int[] xs, int[] ys, int n) {
//		ArrayList<Integer> tx = new ArrayList<Integer>();
//		ArrayList<Integer> ty = new ArrayList<Integer>();
//		min = Integer.MAX_VALUE;
//		walk(xs,ys,tx,ty,0,n);
//		return min;
//	}
//
//	private static void walk(int[] xs, int[] ys, ArrayList<Integer> tx, ArrayList<Integer> ty, int pos, int n) {
//		if(n==0){
//			int centerX = 0;
//			int centerY = 0;
//			int num = tx.size();
//			for(int i=0;i<num;++i){
//				centerX+=tx.get(i);
//				centerY+=ty.get(i);
//			}
//			
//			centerX = centerX / num;
//			centerY = centerY / num;
//			
//			for(int i=-50;i<=50;++i){
//				for(int j=-50;j<=50;++j){
//					
//					int nx = centerX +i;
//					int ny = centerY +j;
//					
//					int minDiff = 0;
//					for(int k=0;k<num;++k){
//						minDiff+= Math.abs(nx - tx.get(k));
//						minDiff+= Math.abs(ny - ty.get(k));
//					}
//					
//					min = Math.min(minDiff, min);
//				}
//			}
//			
//			
//		}
//		
//		if(pos==xs.length){
//			return;
//		}
//		
//		for(int i=pos;i<xs.length ;++i){
//			if(xs.length-i+1<n){
//				continue;
//			}
//			
//			tx.add(xs[i]);
//			ty.add(ys[i]);
//			
//			walk(xs, ys, tx, ty, i+1, n-1);
//			
//			tx.remove(tx.size()-1);
//			ty.remove(ty.size()-1);
//		}
//	}
	
}
