package code.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=46&tqId=29076&rp=2&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=3
 *
 * @author mindw
 * @date 2017年8月8日
 */
public class LevelOrder {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        //层序遍历需要用到队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //推荐用offer代替add
        queue.offer(root);
        while(!queue.isEmpty()){
            //用size控制循环次数
            int size=queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(list);
        }
        return res;
		
//		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//		
//		if(root==null){
//			return ans;
//		}
//		
//		Queue<TreeNode> cur = new LinkedList<>();
//		Queue<TreeNode> next = new LinkedList<>();
//		
//		cur.add(root);
//		TreeNode node;
//		
//		while (true) {
//			
//			ArrayList<Integer> ls = new ArrayList<>();
//			while (!cur.isEmpty()) {
//				
//				node = cur.poll();
//				ls.add(node.val);
//
//				if (node.left != null) {
//					next.add(node.left);
//				}
//
//				if (node.right != null) {
//					next.add(node.right);
//				}
//			}
//			
//			ans.add(ls);
//			if(next.size()==0){
//				break;
//			}else{
//				Queue<TreeNode> tmp = cur;
//				cur = next;
//				next = tmp;
//			}
//
//		}
//		
//		return ans;
		
		
    }
	
}
