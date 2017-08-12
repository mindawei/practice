package company.netease;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 租金
		int f = sc.nextInt(); // 已经有的苹果
		int d = sc.nextInt(); // 钱
		int p = sc.nextInt(); // 苹果单价
		
		if(f*x>=d){
			System.out.println(d/x);
		}else{
			int days = f;
			d -= f*x;
			int moneyPerDay = x +p;
			days += d / moneyPerDay;
			System.out.println(days);
		}
	}
}
