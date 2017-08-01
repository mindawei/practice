package code.offer;

public class ReConstructBinaryTree {

	  // Definition for binary tree
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		  if(pre==null||in==null||pre.length!=in.length||pre.length==0){
			  return null;
		  }
		  return build(pre,0,pre.length-1,in,0,in.length-1);
	  }

	private TreeNode build(int[] pre, int pi, int pj, int[] in, int ii, int ij) {
		
		if(pi>pj){
			return null;
		}
		
		
		TreeNode node = new TreeNode(pre[pi]);
		if(pi==pj){
			return node;
		}
		
		int i;
		for(i=ii;i<=ij;++i){
			if(in[i]==node.val){
				break;
			}
		}

		
		node.left  = build(pre, pi+1, pi+1+(i-1-ii), in, ii, i-1);
		node.right = build(pre, pj-(ij-i-1), pj, in, i+1, ij);
		
		return node;
	}
	
	  
	
}
