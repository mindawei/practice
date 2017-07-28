package code_lintcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 *
 * @author mindw
 * @date 2017年7月28日
 */
public class ZigzagLevelOrder {

	public static class TreeNode {
	    public int val;
	    public TreeNode left, right;
	    public TreeNode(int val) {
	        this.val = val;
	       this.left = this.right = null;
	    }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); 
		root.right = new TreeNode(3); 
		System.out.println(zigzagLevelOrder(root));
	}
	
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> vals = new ArrayList<>();
    	if(root==null){
    		return vals;
    	}
    	
    	LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
    	cur.add(root);
    	
    	LinkedList<TreeNode> next = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> tmp;
    	ArrayList<Integer> ls;
    	TreeNode node;
    	boolean isReverse = false;
    	while(!cur.isEmpty()){
    		
    		next.clear();
    		ls = new ArrayList<Integer>(cur.size());
    		while(!cur.isEmpty()){
    			node = cur.poll();
    			ls.add(node.val);
    			if(node.left!=null){
    				next.add(node.left);
    			}
    			if(node.right!=null){
    				next.add(node.right);
    			}
        	}
    		
    		// swap
    		if(isReverse){
    			int i=0,j=ls.size()-1;
    			while(i<j){
    				int val = ls.get(j);
    				ls.set(j, ls.get(i));
    				ls.set(i, val);
    				++i;
    				--j;
    			}
    		}
    		isReverse = !isReverse;
    		
    		tmp = cur;
    		cur = next;
    		next = tmp;
    		
    		vals.add(ls);
    	}
    	
    	return vals;
    }
    
}