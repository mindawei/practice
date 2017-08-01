package code_offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class Add {
	
	public static void main(String[] args) {
		System.out.println(new Add().Add(123, 678));
	}
	 
	public int Add(int num1,int num2) {
		 
		 int sum = 0;
		 int carry = 0;
		 do{
			 sum = num1 ^ num2;
			 carry = num1 & num2;
			 
			 num1 = sum;
			 num2 = carry << 1;
			 
		 }while(carry!=0);
		
		 return sum;
	 }
	
}
