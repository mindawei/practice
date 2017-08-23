package company.todaynews;

import java.util.Scanner;

/**
 * 一个数组里面有正数、0、负数
 * 
 * @author 闵大为
 * @data 2017年8月1日
 * @Description
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        
        	double sum = n;
        	double v = n;
        	for(int i=1;i<m;++i){
        		v = Math.sqrt(v);
        		sum +=v;
        	}
        	
        	 System.out.println(String.format("%.2f", sum));
        }
       
    }
}
