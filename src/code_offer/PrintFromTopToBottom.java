package code_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class PrintFromTopToBottom {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		 ArrayList<Integer> ls = new ArrayList<>();
		 if(root==null){
			 return ls;
		 }
		 
		 Queue<TreeNode> que = new LinkedList<TreeNode>();
		 que.add(root);
		 
		 
		 TreeNode node;
		 while(!que.isEmpty()){
			 node = que.poll();
			 ls.add(node.val);
			 if(node.left!=null){
				 que.add(node.left);
			 }
			 
			 if(node.right!=null){
				 que.add(node.right);
			 }
		 }
		 
		 return ls;
	 }    
	 
}
