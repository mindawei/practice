package code.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * https://www.nowcoder.com/practice/f4523caf0205476985516212047ac8e7?tpId=46&tqId=29068&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月9日
 * @Description
 */
public class IsBalanced {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return height(root)>=0;
	}
	
	private int height(TreeNode root){
		
		if(root!=null){
			int left = height(root.left);
			if(left<0){
				return -1;
			}
			
			int right = height(root.right);
			if(right<0){
				return -1;
			}
			
			if(Math.abs(left-right)>1){
				return -1;
			}
			
			return Math.max(left, right) + 1;
		}
		return 0;
		
	}
}
