package code.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author 闵大为
 * @data 2017年7月28日
 * @Description
 */
public class JumpFloor {
	
	 public int JumpFloor(int target) {
		 
		 if(target<0){
			 throw new RuntimeException("参数错误");
		 }else if(target<=2){
			 return target;
		 }
		 
		 int f1 = 1;
		 int f2 = 2;
		 int f3 = 3;
		 for(int i=3;i<=target;++i){
			 f3 = f1 +f2;
			 f1 = f2;
			 f2 = f3;
		 }
		 return f3;
		 
	 }
}
