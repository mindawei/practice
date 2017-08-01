package code.hihoCoder;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = in.nextInt();
		}
		System.out.println(solves(nums));
		// in.close();
	}

	private static long solves(int[] nums) {
		n = nums.length;
		if (n < 3) {
			return 0;
		}

		long sum = 0; 
		for(int i=0;i<n;++i){
			sum += nums[i];
		}
		
		boolean ng = sum < 0;
		sum = Math.abs(sum);
		
		long ys = sum % 3;
		long part = sum / 3;
		
		long num = 0;
		if (ys == 0) {
			num += work(ng,part,part,part);
		} else if (ys == 1){
			num += work(ng,part+1,part,part);
			num += work(ng,part,part+1,part);
			num += work(ng,part,part,part+1);
		}else{
			num += work(ng,part,part+1,part+1);
			num += work(ng,part+1,part,part+1);
			num += work(ng,part+1,part+1,part);
		}
			
		return num;
	}

	static HashMap<Long, Long> ma = new HashMap<>();
	static int n;
	static int[] nums;
	static long work(boolean ng,Long x, Long y, Long z) {
		if(ng){
			x = -x;
			y = -y;
			z = -z;
		}
		
		Long res = 0L;
	    ma.clear();
	    Long as = 0L;
	    Long v;
	    for (int i = 0; i < n - 1; i++) {
	        as += nums[i];
	        if(as == x + y) {
	        	v = ma.get(x);
	        	if(v!=null){
	        		res += v;
	        	}
	        }
	        if((v=ma.get(as))!=null){
	        	ma.put(as, v+1);
	        }else{
	         	ma.put(as, 1L);
	        }
	    }
	    return res;
	}
}
