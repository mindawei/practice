import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = (int)Math.pow(2, k)-1;
		
		System.out.println(find(1,n,a,b,c));;
	
	}

	private static int find(int left, int right, int a, int b, int c) {
		int mid = (left+right) >>  1;
		if(a==mid||b==mid||c==mid){
			return mid;
		}else if(a<mid&&b<mid&&c<mid){
			return find(mid, mid-1, a, b, c);
		}else if(a>mid&&b>mid&&c>mid){
			return find(mid+1, right, a, b, c);
		}else{
			return mid;
		}
	}
	
}
