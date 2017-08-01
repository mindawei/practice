package code.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * 可以利用TreeSet https://www.nowcoder.com/profile/631996/codeBookDetail?submissionId=1512262
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class Permutation {
	
	public static void main(String[] args) {
		System.out.println(new Permutation().Permutation("abc"));
	}
	  
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> ans = new ArrayList<>();
		
		
		if(str==null||str.length()==0){
			return ans;
		}
		
		
		char[] chs = str.toCharArray();
		Arrays.sort(chs);
		
		visist(chs, 0,ans);
		
		return ans;
	}
	
	
	private void visist(char[] chs,int pos,	ArrayList<String> ans){
		
		if(pos==chs.length){
			ans.add(new String(chs));
			return;
		}
		
		visist(chs, pos+1, ans);
		
		char ch0,ch1;
		for(int i=pos+1;i<chs.length;++i){
			
			ch0 = chs[pos]; ch1 = chs[i];
			
			if(ch0!=ch1){
				
				for(int j=i;j>pos;--j){
					chs[j] = chs[j-1] ;
				}
				chs[pos] = ch1;
				
				visist(chs, pos+1, ans);
				
				
				for(int j=pos;j<i;++j){
					chs[j] = chs[j+1] ;
				}
				chs[i] = ch1;
				
			}
		
		}
		
	}
}
