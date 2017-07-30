package code_offer;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FindGreatestSumOfSubArray {
	  public int FindGreatestSumOfSubArray(int[] array) {
		  
		  if(array==null||array.length==0){
			  return 0;
		  }
		  
		  int sum = 0;
		  int maxSum = Integer.MIN_VALUE;
		  
		  for(int v : array){
			  if(sum>=0){
				  sum+=v;
			  }else{
				  sum = v;
			  }
			  maxSum = Math.max(sum, maxSum);
		  }
		  
		  return maxSum;
	  }
}
