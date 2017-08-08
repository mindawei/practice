package code.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * https://www.nowcoder.com/practice/1b0b7f371eae4204bc4a7570c84c2de1?tpId=46&tqId=29077&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月8日
 */
public class IsSymmetric {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if(root==null){
			return true;
		}
		return _isSymmetric(root.left,root.right);
	}

	private boolean _isSymmetric(TreeNode left, TreeNode right) {
		
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		}
		
		if(left.val!=right.val){
			return false;
		}
		
		
		return false;
	}
}
