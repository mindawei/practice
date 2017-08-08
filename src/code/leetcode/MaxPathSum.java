package code.leetcode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * 
 * https://www.nowcoder.com/practice/da785ea0f64b442488c125b441a4ba4a?tpId=46&tqId=29056&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月8日
 */
public class MaxPathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public int maxPathSum(TreeNode root) {

		int maxVal = root.val;
		if (root.left != null) {
			maxVal = Math.max(maxVal, maxPathSum(root.left));
		}
		
		if (root.right != null) {
			maxVal = Math.max(maxVal, maxPathSum(root.right));
		}

		int middleMax = pathSum(root.left) + pathSum(root.right) + root.val;
		maxVal = Math.max(maxVal, middleMax);

		return maxVal;

	}

	public int pathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}
		
		int maxVal = root.val;
		maxVal = Math.max(maxVal, root.val + pathSum(root.left));
		maxVal = Math.max(maxVal, root.val + pathSum(root.right));
		
		return Math.max(maxVal,0);
	}
	
//	 int maxValue;
//	    public int maxPathSum(TreeNode root) {
//	        maxValue = Integer.MIN_VALUE;
//	        maxPathDown(root);
//	        return maxValue;    
//	    }
//	    private int maxPathDown(TreeNode node){
//	        if(node==null)
//	            return 0;
//	        int left = Math.max(0, maxPathDown(node.left));
//	        int right = Math.max(0, maxPathDown(node.right));
//	        maxValue = Math.max(maxValue, left + right + node.val);
//	        return Math.max(left, right) + node.val;
//	    }
}
