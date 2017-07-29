package code_offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class Mirror {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	   public void Mirror(TreeNode root) {
		   if(root!=null){
			   TreeNode tmp = root.left;
			   root.left = root.right;
			   root.right = tmp;
			   Mirror(root.left);
			   Mirror(root.right);
		   }
		   
	    }
	   
	   
}
