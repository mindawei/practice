package code.offer;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class TreeDepth {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public int TreeDepth(TreeNode root) {
		if(root!=null){
			int left = TreeDepth(root.left);
			int right = TreeDepth(root.right);
			return Math.max(left, right)+1;
		}
		return 0;
	}

}
