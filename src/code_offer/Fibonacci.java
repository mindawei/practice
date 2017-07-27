package code_offer;

/**
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class Fibonacci {
	 public int Fibonacci(int n) {
		 if(n==0){
			 return 0;
		 }
		 
		 if(n==1||n==2){
			 return 1;
		 }
		 
		 int f1 = 1,f2 = 1,f3 = 2;
		 for(int i=3;i<=n;++i){
			 f3 = f1 + f2;
			 f1 = f2;
			 f2 = f3;
		 }
		 return f3;
	 }
}
