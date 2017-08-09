package company.huawei;

import java.util.Scanner;

public class Solution2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(solve(str));
	}

	private static String solve(String str) {
		StringBuilder sb = new StringBuilder();
		char[] chs = str.toCharArray();
		final String error = "!error";
		int i=0;
		while(i<chs.length){
			if(chs[i]>='1'&&chs[i]<='9'){
				// 123a
				i = getNumChar(chs,i,sb);
			}else if(chs[i]>='a'&&chs[i]<='z'){ // a ab
				i = getChar(chs,i,sb);
			}else{
				i=-1;
			}
			if(i==-1){
				return error;
			}
		}
		
		return sb.toString();
	}

	private static int getChar(char[] chs, int i, StringBuilder sb) {
		
		char ch = chs[i];
		sb.append(ch);

		if(i+1<chs.length && chs[i+1]==ch){
			sb.append(ch);
			++i;
		}
		
		if(i+1<chs.length && chs[i+1]==ch){
			return -1;
		}
		
		return i+1;
	}

	private static int getNumChar(char[] chs, int i, StringBuilder sb) {
		
		int num = 0;
		while(i<chs.length && chs[i]>='0'&&chs[i]<='9'){
			num = num * 10 + (chs[i]-'0');
			++i;
		}
		
		if(i==chs.length||num<=2){
			return -1;
		}
		
		if(chs[i]>='a'&&chs[i]<='z'){
			if(i+1<chs.length&&chs[i]==chs[i+1]){
				return -1;
			}
			
			for(int j=0;j<num;++j){
				sb.append(chs[i]);
			}
			
			return i+1;
		}else{
			return -1;
		}
	}
}
