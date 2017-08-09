package company.huawei;

import java.util.Scanner;

public class Solution1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = in.next();
		}
		System.out.println(solve(strs));
	}

	private static String solve(String[] strs) {
		StringBuilder sb = new StringBuilder();
		for(String str : strs){
			for(int i=str.length()-1;i>=0;--i){
				if(Character.isDigit(str.charAt(i))){
					sb.append(str.charAt(i));
				}else{
					break;
				}
			}
		}
		return sb.toString();
	}
	
}
