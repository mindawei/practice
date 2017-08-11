package code.leetcode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 * 
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=46&tqId=29090&tPage=4&rp=3&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * 
 * 
 * @author 闵大为
 * @data 2017年8月11日
 * @Description
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int len = m+n;
        int p0 = m-1;
        int p1 = n-1;
        while(p0>=0&&p1>=0){
        	if(A[p0]>B[p1]){
        		A[--len] = A[p0--];
        	}else{
        		A[--len] = B[p1--];
        	}
        }
        
        if(p0<0){
        	while(p1>=0){
        		A[--len] = B[p1--];
        	}
        }
    }
}
