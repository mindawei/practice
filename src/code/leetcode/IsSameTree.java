package code.leetcode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * https://www.nowcoder.com/practice/9a9e74b71f944efab9992925f7f9a65e?tpId=46&tqId=29078&tPage=3&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月10日
 */
public class IsSameTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	 public boolean isSameTree(TreeNode p, TreeNode q) {
	     
		 if(p==null&&q==null){
			 return true;
		 }else if(p==null||q==null){
			 return false;
		 }
		 
		 if(p.val==q.val){
			 return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		 }else{
			 return false;
		 }
	 }
	
}
