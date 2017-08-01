package code.offer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FindContinuousSequence {
	 public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	     
		 ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		 if(sum<=0){
			 return ls;
		 }
		 
		 int mid = (sum+1)>>1;
		 int small = 1;
		 int big = 2;
		 int v = small+big;
		 while(small<mid){
			 if(v==sum){
				 ArrayList<Integer> ans = new ArrayList<>();
				 for(int i=small;i<=big;++i){
					 ans.add(i);
				 }
				 ls.add(ans);
				 v-=small;
				 ++small;
			 }else if(v>sum){
				 v-=small;
				 ++small;
			 }else{
				 ++big;
				 v+=big;
			 }
		 }
		 return ls;
	  }
}
