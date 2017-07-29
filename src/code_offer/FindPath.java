package code_offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class FindPath {
	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if(root==null){
			return ans;
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		
		find(root,target,path,ans);
		
		return ans;
	}

	private void find(TreeNode node, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
		
		path.add(node.val);
		target -= node.val;
		
		// leaf node
		if(node.left==null&&node.right==null){
			if(target==0){		
				ans.add(new ArrayList<>(path));	
			}
		}else{
			if(node.left!=null){
				find(node.left, target, path, ans);
			}
			if(node.right!=null){
				find(node.right, target, path, ans);
			}
		}
		
		path.remove(path.size()-1);
	}

	

}
