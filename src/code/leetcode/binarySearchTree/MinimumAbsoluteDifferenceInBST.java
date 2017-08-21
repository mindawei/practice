package code.leetcode.binarySearchTree;

/**
 * Given a binary search tree with non-negative values, 
 * find the minimum absolute difference between values of any two nodes.
 *
 * 二叉搜索树的任意两个节点之间的最小差值（节点非负）
 * 思路：中序遍历前面节点和后继节点的差值
 * 
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 * 
 * @author mindw
 * @date 2017年8月18日
 */
public class MinimumAbsoluteDifferenceInBST {
	
	public class TreeNode {
		   int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; }
	}
	
	private TreeNode pre;
	private int minDiff;
	
	public int getMinimumDifference(TreeNode root) {
        pre = null;
        minDiff = Integer.MAX_VALUE;
        LDR(root);
		return minDiff;
    }
	
	// 时间 O(n) 空间O(1)
	private void LDR(TreeNode root) {
		if(root==null) return;
		LDR(root.left);
		if(pre!=null){
			minDiff = Math.min(minDiff,root.val-pre.val);
		}
		pre = root;
		LDR(root.right);
	}
}
