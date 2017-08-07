package code.leetcode;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=46&tqId=29051&tPage=2&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月7日
 */
public class SumNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return vis(root,0);
	}
	
	private int vis(TreeNode root, int v) {
		if(root==null){
			return 0;
		}
		
		v = (v<<3) + (v<<1) + root.val;
		if(root.left==null&&root.right==null){
			return v;
		}else{
			return vis(root.left, v) + vis(root.right, v);
		}
	}
}
