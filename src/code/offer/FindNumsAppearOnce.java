package code.offer;


/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FindNumsAppearOnce {
	
  // num1,num2分别为长度为1的数组。传出参数
  // 将num1[0],num2[0]设置为返回结果
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	  int result = 0;
	  for(int val : array){
		  result ^= val;
	  }
	  
	  // find tag bit
	  int index = 0;
	  while((result&1)==0){
		  ++index;
		  result >>>=1;
	  }
	  
	  num1[0] = num2[0] = 0;
	  for(int val : array){
		  if(((val>>>index)&1)==0){
			  num1[0] ^= val;
		  }else{
			  num2[0] ^= val;
		  }
	  }
  }
}