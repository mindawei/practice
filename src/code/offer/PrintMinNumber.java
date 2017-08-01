package code.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class PrintMinNumber {
	
	public String PrintMinNumber(int [] numbers) {
		if(numbers==null||numbers.length==0){
			return "";
		}
		
		String[] strs = new String[numbers.length];
		
		for(int i=0;i<numbers.length;++i){
			strs[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strs,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String s12 = s1.concat(s2);
				String s21 = s2.concat(s1);
				return s12.compareTo(s21);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : strs){
			sb.append(str);
		}
		return sb.toString();
    }
	
}
