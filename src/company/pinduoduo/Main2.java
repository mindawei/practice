package company.pinduoduo;

import java.util.Scanner;

/**
 * 大数相乘
 * 
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */
public class Main2 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		bigNumberSimpleMulti(sc.next(), sc.next());
	}


	public static void bigNumberSimpleMulti(String num1, String num2) {  
		
		int len1 = num1.length();
		int len2 = num2.length();
		long[] p = new long[len1+len2];
		
		for(int i=0;i<num1.length();++i){
			for(int j=0;j<num2.length();++j){
				p[i+j] += ((long)(num1.charAt(len1-1-i) - '0'))*(num2.charAt(len2-1-j) - '0');
			}
		}
	
		long carry = 0;
		for(int i=0;i<p.length;++i){
			long result = p[i] + carry;
			p[i] = result % 10;
			carry = result / 10;
		}
    
		int i = p.length-1;
		while(i>=0&&p[i]==0){
			--i;
		}
		
		if(i<0){
			System.out.println('0');
		}else{
			while(i>=0){
				System.out.print(p[i]);
				--i;
			}
			System.out.println();
		}
	}  
}
