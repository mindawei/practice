package code.leetcode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * https://www.nowcoder.com/practice/fd7f880072914464a13b89af242c0ce5?tpId=46&tqId=29080&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月10日
 */
public class IsValidBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode preNode = null;

	public boolean isValidBST(TreeNode root) {
		return LDR(root);
	}

	private boolean LDR(TreeNode root) {
		if (root == null)
			return true;
		
		if (!LDR(root.left)) {
			return false;
		}

		if (preNode != null && preNode.val >= root.val) {
			return false;
		}
		
		preNode = root;
		return LDR(root.right);
	}
}
