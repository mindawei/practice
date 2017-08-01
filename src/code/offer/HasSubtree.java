package code.offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class HasSubtree {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	    	if(root2==null){
	    		return false;
	    	}
	    	return _HasSubtree(root1, root2);
	    }
	 
    public boolean _HasSubtree(TreeNode root1,TreeNode root2) {
    	if(root1==null&&root2==null){
    		return true;
    	}else if(root1==null){
    		return false;
    	}else if(root2==null){
    		return true;
    	}
    	
    	if(root1.val==root2.val){
    		if(_HasSubtree(root1.left, root2.left)&&_HasSubtree(root1.right, root2.right)){
    			return true;
    		}
    	}
    	
    	return _HasSubtree(root1.left, root2)||_HasSubtree(root1.right, root2);
    }
    
}
