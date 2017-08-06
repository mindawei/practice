package code.leetcode;

import java.util.ArrayList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * https://www.nowcoder.com/practice/840dd2dc4fbd4b2199cd48f2dadf930a?tpId=46&tqId=29066&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=2
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class PathSumII {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
	        
		 ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		 if(root==null){
			 return ans;
		 }
		 
		 ArrayList<Integer> path = new ArrayList<>();
		 _pathSum(ans,root,path,sum);
		 
		 return ans;
	 }

	private void _pathSum(ArrayList<ArrayList<Integer>> ans,TreeNode root, ArrayList<Integer> path, int sum) {
		if(root==null){
			return;
		}
		
		sum-= root.val;
		path.add(root.val);
		
		if(root.left==null&&root.right==null&&sum==0){
			ans.add(new ArrayList<>(path));
		}else{
			_pathSum(ans,root.left,path,sum);
			_pathSum(ans,root.right,path,sum);
		}
		
		path.remove(path.size()-1);
		
	}

}
