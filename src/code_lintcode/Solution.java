package code_lintcode;

/**
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 一棵BST定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 *
 * @author mindw
 * @date 2017年7月28日
 */
public class Solution {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if the binary tree is BST, or false
	 */
	public boolean isValidBST(TreeNode root) {
		if(root==null){
			return true;  
		}
		
		int val = root.val;
		if(root.left!=null && root.left.val>=val){
			return false;
		}
		if(root.right!=null && root.left.val>=val){
			
		}
	}

}
