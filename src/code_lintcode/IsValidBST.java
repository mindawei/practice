package code_lintcode;

/**
 * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
 * 一棵BST定义为：
 * 节点的左子树中的值要严格小于该节点的值。
 * 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。
 * 一个节点的树也是二叉查找树。
 * 
 * http://www.lintcode.com/zh-cn/problem/validate-binary-search-tree/
 * http://www.jiuzhang.com/solutions/validate-binary-search-tree/
 *
 * @author mindw
 * @date 2017年7月28日
 */
public class IsValidBST {

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
	
	 private int lastVal = Integer.MIN_VALUE;
	    private boolean firstNode = true;
	    /**
	     * 二叉树的中序遍历从小到大递增，所以可以用lastVal表示上次遍历的节点
	     */
	    public boolean isValidBST(TreeNode root) {
	        if (root == null) {
	            return true;
	        }
	        if (!isValidBST(root.left)) {
	            return false;
	        }
	        if (!firstNode && lastVal >= root.val) {
	            return false;
	        }
	        firstNode = false;
	        lastVal = root.val;
	        if (!isValidBST(root.right)) {
	            return false;
	        }
	        return true;
	    }
	    
	    
//	public boolean isValidBST(TreeNode root) {
//		return visit(root, 0,false,0,false);
//	}
//	
//	private boolean visit(TreeNode root,int left,boolean isLeftValid,int right,boolean isRightValid){
//		if(root == null){
//			return true;  
//		}
//				
//		if(isLeftValid && root.val<=left){
//			return false;
//		}
//		
//		if(isRightValid && root.val>=right){
//			return false;
//		}
//		
//		return visit(root.left,left,isLeftValid,root.val,true) && visit(root.right,root.val,true,right,isRightValid);
//		
//	}
	
	

}
