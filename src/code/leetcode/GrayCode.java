package code.leetcode;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return[0,1,3,2]. 
 * 
 * https://www.nowcoder.com/practice/55dddb4cdf074fefba653ff523e42346?tpId=46&tqId=29089&tPage=3&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class GrayCode {
	 public ArrayList<Integer> grayCode(int n) {
		 ArrayList<Integer> ans = new ArrayList<>();
		 ans.add(0);
		 int size;
		 for(int i=1;i<=n;++i){
			 for(int j=(size = ans.size())-1;j>=0;--j){
				 ans.add(ans.get(j)+size);
			 }
		 }
		 return ans;
	 }
}
