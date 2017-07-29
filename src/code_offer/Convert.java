package code_offer;

public class Convert {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	
	private TreeNode head = null;
	private TreeNode pre = null;
			
    public TreeNode Convert(TreeNode pRootOfTree) {
    	_Convert(pRootOfTree);
    	return head;
    }
    
    public void _Convert(TreeNode pRootOfTree) {
        if(pRootOfTree!=null){
        	_Convert(pRootOfTree.left);
        	
        	if(head == null){
        		head = pRootOfTree;
        	}
        	
        	pRootOfTree.left = pre;
        	if(pre!=null){
        		pre.right = pRootOfTree;
        	}
        	pre = pRootOfTree;
        	
        	_Convert(pRootOfTree.right);
        	
        }
    }
    
    
}
