package code.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class JumpFloorII {
	   public int JumpFloorII(int target) {
	       // 2^n-1
		   if(target<=0){
			   return 0;
		   }
		   if(target==1){
			   return 1;
		   }
		   
		   return exp(target-1);
	   }

	private int exp(int target) {
		
		if(target==0){
			return 1;
		}
		
		int m ;
		if((target&1)==0){ // 偶数
			m = 1;
		}else{ // 奇数
			m = 2;
		}
		
		int half = exp(target/2);
	
		return half*half*m;
	}
	   
	   
	   
}
