package code.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * return[3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * https://www.nowcoder.com/practice/32af374b322342b68460e6fd2641dd1b?tpId=46&tqId=29035&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月3日
 */
public class PostorderTraversal {

	  public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	  // LRD 
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> ls = new ArrayList<>();
		Stack<TreeNode> nodes = new Stack<>();
		Stack<Boolean> vis = new Stack<>();
		
		TreeNode p = root;
		while(p!=null||!nodes.isEmpty()){
			
			while(p!=null){
				nodes.push(p);
				vis.push(false);
				p = p.left;
			}
			
			if(!nodes.isEmpty()){
				if(vis.pop()){
					ls.add(nodes.pop().val);
					p = null;
				}else{
					vis.push(true);
					p = nodes.peek().right;
				}
			}
			
		}
		return ls;
	 }
}
