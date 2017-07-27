package offer;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
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