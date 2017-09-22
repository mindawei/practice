
public class Sqrt {
	
	public static double precision = 0.0001;
	
	public static void main(String[] args) {
		System.out.println(sqrt(3));
		System.out.println(Math.sqrt(3));
	}
	
	
	public static double sqrt(double n) {
		double xn = n;
		
		while(Math.abs(xn*xn-n)>=precision) {
			xn = xn - (xn*xn-n) / (2*xn);
		}
		
		return xn;
	}
	
	
	public static double sqrt2(double n) {
		double left = 0;
		double right = n;
		double mid = 0;
		while(left<right) {
			mid = (left + right) / 2;
		    double mid2 = mid *mid;
		    if(Math.abs(mid2-n)<precision) {
		    	return mid;
		    }else if(mid2<n) {
		    	left = mid;
		    }else {
		    	right = mid;
		    }
		}
		return mid;
	}

}
