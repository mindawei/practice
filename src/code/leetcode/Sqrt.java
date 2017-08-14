package code.leetcode;

/**
 * Implementint sqrt(int x).Compute and return the square root of x.
 * 
 * https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=46&tqId=29109&rp=2&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=4
 *
 * @author mindw
 * @date 2017年8月14日
 */
public class Sqrt {
	
	public static void main(String[] args) {
		Sqrt sqrt = new Sqrt();
		for(int i=0;i<10;++i){
		System.out.println(i+" "+sqrt.sqrt(i));
		}
		
		System.out.println(sqrt.sqrt(2147395599));
		System.out.println(46339*46339);
		// 2147395600
		// 2147483647
		// 2147395599
	}
	
	public int sqrt(int x) {
		if (x <= 1) {
			return x;
		}

		int i = 1;
		int j = x >> 1;
		while (i <= j) {
			long mid = (i + j) >> 1;
			long v = mid * mid;
			if (v == x) {
				return (int)mid;
			} else if (v < x) {
				i = (int)(mid + 1);
			} else {
				j = (int)(mid - 1);
			}
		}

		return j;
	}
}
