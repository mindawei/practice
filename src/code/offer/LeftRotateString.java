package code.offer;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class LeftRotateString {
	
	public static void main(String[] args) {
		new LeftRotateString().LeftRotateString("", 6);
	}
    
	public String LeftRotateString(String str,int n) {
		if(str==null||n<0){
			throw new RuntimeException("Invalid parameter!");
		}
		
		if(str.length()==0){
			return "";
		}
		
		n = n % str.length();
		
		char[] chs = str.toCharArray();
		reverse(chs, 0, n-1);
		reverse(chs, n, chs.length-1);
		reverse(chs, 0, chs.length-1);
		
		return new String(chs);
    }
	
	private void reverse(char[] chs,int begin,int end){
		char tmp;
		while(begin<end){
			tmp = chs[begin];
			chs[begin] = chs[end];
			chs[end] = tmp;
			
			++begin;
			--end;
		}
	}
}
