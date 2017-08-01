package code.offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class IsBalanced {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	   
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root) != -1;
	}

	private int isBalanced(TreeNode root) {
		if(root!=null){
			int left = isBalanced(root.left);
			if(left==-1){
				return -1;
			}
			int right = isBalanced(root.right);
			if(right==-1){
				return -1;
			}
			
			if(Math.abs(left-right)>1){
				return -1;
			}
			
			return 1 + Math.max(left,right);
		}
		return 0;
	}
	   
}
