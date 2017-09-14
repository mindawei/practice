package company.jd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] strs = line.split(",");
			
			int n = Integer.parseInt(strs[0]);
			if(n<3){
			    System.out.println("incorrect data");
				continue;
			}
			
			long timeOff = 0;
	        try {
	            Date dt1 = df.parse(strs[1]);
	            Date dt2 = df.parse(strs[2]);
	            timeOff = dt2.getTime() - dt1.getTime();
	            if(dt1.getSeconds()!=0||dt2.getSeconds()!=0||timeOff<0){
	            	 System.out.println("incorrect data");
	 				continue;
	            }
	            
	            // 多少秒
	            timeOff /=  1000; 
	            
	        } catch (Exception exception) {
	            exception.printStackTrace();
	        }
			
	       
	        long cycle = n * (900);
			
	        long round = timeOff / cycle;
	        timeOff -= cycle * round;
	        System.out.print(round+1+";");
	        
	        long base = timeOff / 900;
	        timeOff -= base * 900;
	      
	        base = base + 1;
	        if(base==n+1){
	        	base = 1;
	        }
	        long base1 = base+1;
	        if(base1==n+1){
	        	base1 = 1;
	        }
	        
	        if(timeOff==0){
	        	System.out.println(base+"-"+base);
	        }else if(timeOff<600){
	        	System.out.println(base+"-"+base1);
	        }else{
	        	System.out.println(base1+"-"+base1);
	        }
	        
	        
		}
	}
}
