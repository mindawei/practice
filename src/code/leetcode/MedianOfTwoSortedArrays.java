package code.leetcode;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * https://www.nowcoder.com/practice/82c11b9392b14f3abfbf257f79a76025?tpId=46&tqId=29176&rp=2&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=8
 *
 * @author mindw
 * @date 2017年8月7日
 */
public class MedianOfTwoSortedArrays {
	  
	// http://www.jiuzhang.com/solution/median-of-two-sorted-arrays
	public double findMedianSortedArrays(int A[], int B[]) {
		int len = A.length + B.length;
		if((len&1)==1){
			return find(A,0,B,0,(len>>1) + 1);
		}else{
			return (find(A,0,B,0,(len>>1)) + find(A,0,B,0,(len>>1)+1)) / 2.0;
		}
	}

	private int find(int[] A, int A_start, int[] B, int B_start, int k) {
		if(A_start>=A.length){
			return B[B_start+k-1];
		}
		
		if(B_start>=B.length){
			return A[A_start+k-1];
		}
		
		if(k==1){
			return Math.min(A[A_start], B[B_start]);
		}
		
		int indexA = (A_start+k/2-1);
		int valA = indexA < A.length ? A[indexA] : Integer.MAX_VALUE;
		
		int indexB = (B_start+k/2-1);
		int valB = indexB < B.length ? B[indexB] : Integer.MAX_VALUE;
		
		if (valA < valB) {
			return find(A, indexA + 1, B, B_start, k - k/2);
		} else {
			return find(A, A_start, B, indexB + 1, k - k/2);
		}
	}
	
}
