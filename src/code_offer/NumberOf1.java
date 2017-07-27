package code_offer;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class NumberOf1 {
	 public int NumberOf1(int n) {
		 int num = 0;
		 while(n!=0){
			 n &= (n-1);
			 num++;
		 }
		 return num;
	 }
}
