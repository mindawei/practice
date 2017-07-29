package code_offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class RectCover {
	 public int RectCover(int target) {
		 if(target<=2){
			 return target;
		 }
		 
		 int f1 =1,f2 =2,f3=3;
		 for(int i=3;i<=target;++i){
			 f3 = f1 + f2;
			 f1 = f2;
			 f2 = f3;
		 }
		 return f3;
		 
	 }
}
