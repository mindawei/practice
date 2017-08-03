package code.leetcode;

/**
 * Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * https://www.nowcoder.com/practice/e08819cfdeb34985a8de9c4e6562e724?tpId=46&tqId=29030&tPage=1&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月3日
 */
public class MinTreeDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int run(TreeNode root) {
		return minDepth(root);
	}

	public int minDepth(TreeNode root) {
		if (root != null) {
			int leftHeight = minDepth(root.left);
			int rihgtHeight = minDepth(root.right);
			
			if(leftHeight==0){
				return rihgtHeight + 1;
			}else if(rihgtHeight==0){
				return leftHeight + 1;
			}else{
				return Math.min(leftHeight, rihgtHeight)+1;
			}
		}
		return 0;
	}

}
