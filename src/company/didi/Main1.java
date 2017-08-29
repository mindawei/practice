package company.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		ArrayList<Integer> num = new ArrayList<>();
		
		String line = sc.nextLine();
		for(String str : line.split(" ")){
			num.add(Integer.parseInt(str));
		}
		
		int maxSum = num.get(0);
		int sum = num.get(0);
		for(int i=1;i<num.size();++i){
			if(sum>=0){
				sum = sum + num.get(i);
			}else{
				sum = num.get(i);
			}
			maxSum = Math.max(sum, maxSum);
			
		}
		System.out.println(maxSum);
	}
}
