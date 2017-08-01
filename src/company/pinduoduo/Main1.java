package company.pinduoduo;

import java.util.Scanner;

/**
 * 一个数组里面有正数、0、负数
 * 
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */
public class Main1 {
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
		
		if(arr==null||arr.length<=2){
			return 0;
		}
		
		boolean ismax1 = false;
		boolean ismax2 = false;
		boolean _ismax1 = false;
		boolean _ismax2 = false;
	
		long max1=0; long max2=0;long _max1=0;long _max2=0;
	    
		long ans = Long.MIN_VALUE;
		
		long v;
		for(int i=0;i<arr.length;++i){
			
			//System.out.println(max1+" "+max2+" "+_max1+" "+_max2);
			v = arr[i];
			
			if(ismax1&&ismax2){
				ans = Math.max(ans, v*max1*max2);
			}
			
			if(_ismax1&&_ismax2){
				ans = Math.max(ans, v*_max1*_max2);
			}
			
			if(ismax1&&_ismax1){
				ans = Math.max(ans, v*max1*_max1);
			}
			
			if(v==0){
				ans = Math.max(ans, 0);
			}else if(v>0){
				if(!ismax1){
					ismax1 = true;
					max1 = v;
				}else if(!ismax2){
					ismax2 = true;
					max2 = Math.min(v,max1);
					max1 = Math.max(v,max1);
				}else{
					if(v>=max1){
						max2 = max1;
						max1 = v;
					}else{
						max2 = Math.max(v,max2);
					}
				}
			}else{ // if(v<0){
				
				
				if(!_ismax1){
					_ismax1 = true;
					_max1 = v;
				}else if(!_ismax2){
					_ismax2 = true;
					_max2 = Math.max(v,_max1);
					_max1 = Math.min(v,_max1);
				}else{
					if(v<=_max1){
						_max2 = _max1;
						_max1 = v;
					}else{
						_max2 = Math.min(v,_max2);
					}
				}
			}
	
		}
		
		return ans;
	}
}
