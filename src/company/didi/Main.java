package company.didi;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// empty
		boolean[] f = new boolean[n];
		
		int empty = 0;
		for(int i=0;i<n;++i){
			if(sc.nextInt()==1){
				f[i] = false;
			}else{
				empty++;
				f[i] = true;
			}
		}
		
		if(empty<m){
			System.out.println(-1);
		}else{
			boolean[] emp = new boolean[n];
			
			int min = Integer.MAX_VALUE;
			// 所有可能的位置
			for(int i=0;i<n;++i){
				System.arraycopy(f, 0, emp, 0, f.length);		
				min = Math.min(min,getNum(i,emp,m));	
				
			}
			System.out.println(min);
		}
		
	}

	private static int getNum(int pos, boolean[] emp, int m) {

		if(m==0){
			return 0;
		}
	
		int off = (emp.length+1)>>1;
		int sumOff = 0;
		for(int i=0;i<off;++i){
			if(emp[(pos+i)%emp.length]){
				sumOff += i;
				emp[(pos+i)%emp.length] = false;
				--m;
				if(m==0){
					break;
				}
			}
			
			if(emp[(pos-i+emp.length)%emp.length]){
				sumOff += i;
				emp[(pos-i+emp.length)%emp.length] = false;
				--m;
				if(m==0){
					break;
				}
			}
		}

		return sumOff;
	}
}
