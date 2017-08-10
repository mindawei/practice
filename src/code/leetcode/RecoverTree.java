package code.leetcode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note: A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * https://www.nowcoder.com/practice/67c7172122b54b748e78eac7b183b5f3?tpId=46&tqId=29079&rp=3&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月10日
 */
public class RecoverTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;

		
		new RecoverTree().recoverTree(node1);
		
		System.out.println(node1.val);
		System.out.println(node1.right.val);
		
	}
	
	
	public void recoverTree(TreeNode root) {
		LDR(root);
		if(p2!=null){
			int tmp = p1.val;
			p1.val = p2.val;
			p2.val = tmp;
		}
	}

	private TreeNode preNode = null;
	private TreeNode p1=null;
	private TreeNode p2=null;
	
	private void LDR(TreeNode root) {
		if(root!=null){
			LDR(root.left);
			
			if(preNode!=null && preNode.val > root.val){
				if(p1==null){
					p1 = preNode;
					p2 = root;
				}else{
					p2 = root;
					return;
				}
			}
			preNode = root;
			LDR(root.right);
		}
	}
	
//	public void recoverTree(TreeNode root) {
//		if (root == null) {
//			return;
//		}
//		fixed(root,false,0,false,0);
//	}	
//	private boolean isFixed = false;
//	
//	private boolean isIn(int val,boolean includeLeft, int left, boolean includeRight, int right){
//		if (includeLeft && val < left) {
//			return false;
//		} 
//		if (includeRight && val > right) {
//			return false;
//		}
//		return true;
//	}
//	
//	private TreeNode fixed(TreeNode root, boolean includeLeft, int left, boolean includeRight, int right) {
//		
//		if (root == null) {
//			return null;
//		} 
//	
//		if(!isIn(root.val, includeLeft, left, includeRight, right)){
//			return root;
//		}
//
//		TreeNode leftNode = fixed(root.left, includeLeft, left, true, root.val);
//		if (isFixed) {
//			return null;
//		}
//		if(leftNode!=null && !isIn(leftNode.val, includeLeft, left, includeRight, right)){
//			return leftNode;
//		}
//
//		TreeNode rightNode = fixed(root.right, true, root.val, includeRight, right);
//		if (isFixed) {
//			return null;
//		}
//		if(rightNode!=null && !isIn(rightNode.val, includeLeft, left, includeRight, right)){
//			return rightNode;
//		}
//
//		if (leftNode != null && rightNode != null) {
//			int tmp = leftNode.val;
//			leftNode.val = rightNode.val;
//			rightNode.val = tmp;
//
//			isFixed = true;
//		} else if (leftNode != null) {
//			int tmp = leftNode.val;
//			leftNode.val = root.val;
//			root.val = tmp;
//
//			isFixed = true;
//		} else if (rightNode != null) {
//			int tmp = rightNode.val;
//			rightNode.val = root.val;
//			root.val = tmp;
//
//			isFixed = true;
//		}
//
//		return null;
//	}
	
}
