package code.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * return[1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * https://www.nowcoder.com/practice/501fb3ca49bb4474bf5fa87274e884b4?tpId=46&tqId=29036&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=1
 *
 * @author mindw
 * @date 2017年8月3日
 */
public class PreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// D L R
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> ls = new ArrayList<>();
		Stack<TreeNode> nodes = new Stack<>();
		TreeNode p = root;
		while(p!=null||!nodes.isEmpty()){
			while(p!=null){
				ls.add(p.val);
				nodes.add(p);
				p = p.left;
			}
			
			if(!nodes.isEmpty()){
				p = nodes.pop().right;
			}
		}
		return ls;
	}
}
