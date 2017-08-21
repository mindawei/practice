package code.leetcode.binarySearchTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ? j), inclusive.
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 * 
 * @author mindw
 * @date 2017年8月18日
 */
public class CountOfRangeSum {
	
//	class TreeNode {
//		int sum;
//		int left;
//		int right;
//		TreeNode pLeft;
//		TreeNode pRight;
//	}
//	
//	private TreeNode build(int[] nums,int left,int right){
//		if(left>right){
//			return null;
//		}
//		
//		TreeNode node = new TreeNode();
//		node.left = left;
//		node.right = right;
//		
//		if(left==right){
//			node.sum = nums[left];
//			return node;
//		}else{
//			int mid = (left+right) >>> 1;
//			node.pLeft = build(nums, left, mid);
//			node.pRight = build(nums, mid+1, right);
//			 
//			node.sum = 0;
//			if(node.pLeft!=null){
//				node.sum+=node.pLeft.sum;
//			}
//			
//			if(node.pRight!=null){
//				node.sum+=node.pRight.sum;
//			}
//		}
//		return node;
//	}
//	
//	public int countRangeSum(int[] nums, int lower, int upper) {
////		TreeNode root = build(nums, 0, nums.length-1);
//		return 0;
//	}
	
	
	// https://leetcode.com/problems/count-of-range-sum/discuss/
	// 利用归并排序
	public int countRangeSum2(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	              + countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    int r = 0;
	    for (int i = start; i < mid; ++i) {
	        while (k < end && sums[k] - sums[i] < lower) k++;
	        while (j < end && sums[j] - sums[i] <= upper) j++;
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r++] = sums[i];
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
	
	// 二叉树
	class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;
        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
	
    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if(low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if(low == high) return stn;
        int mid = (low + high)/2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid+1, high);
        return stn;
    }
    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if(stn == null) return;
        if(val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }
    private int getCount(SegmentTreeNode stn, long min, long max) {
        if(stn == null) return 0;
        if(min > stn.max || max < stn.min) return 0;
        if(min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }
        
        Long[] valArr = valSet.toArray(new Long[0]);
        
        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length-1);

        for(int i = nums.length-1; i >=0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long)lower+sum, (long)upper+sum);
        }
        return ans;
    }
	
	
}
