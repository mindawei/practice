package code.leetcode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * https://www.nowcoder.com/practice/508378c0823c423baa723ce448cbfd0c?tpId=46&tqId=29067&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=2
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class PathSum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {

		if(root==null){
			return false;
		}
		
		sum-= root.val;
		if(sum==0){
			if(root.left==null&&root.right==null){
				return true;
			}
		}
		
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum); 
		
	}

}
