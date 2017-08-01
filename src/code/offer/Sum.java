package code.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class Sum {
	  public int Sum_Solution(int n) {
		  int sum = n;
	      boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
	      return sum;
	  }
}
