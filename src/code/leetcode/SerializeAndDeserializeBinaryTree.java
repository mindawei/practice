package code.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树序列化和反序列化
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * 答案：https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/
 * 
 * @author mindw
 * @date 2017年8月15日
 */
public class SerializeAndDeserializeBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private static final String NULL_TAG = "#";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		
		if(root==null){
			return NULL_TAG;
		}
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		StringBuilder sb = new StringBuilder();
		sb.append(root.val);
		
		while(!que.isEmpty()){
			TreeNode node = que.poll();
			if(node.left==null){
				sb.append(',');
				sb.append(NULL_TAG);
			}else{
				sb.append(',');
				sb.append(node.left.val);
				que.offer(node.left);
			}
			
			if(node.right==null){
				sb.append(',');
				sb.append(NULL_TAG);
			}else{
				sb.append(',');
				sb.append(node.right.val);
				que.offer(node.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] strs = data.split(",");
		if(strs.length==1&&strs[0].equals(NULL_TAG)){
			return null;
		}
		
		Queue<TreeNode> que = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		que.add(root);
		
		int index = 0;
		while(!que.isEmpty()){
			TreeNode node = que.poll();
			++index;
			if(!strs[index].equals("#")){
				TreeNode leftNode = new TreeNode(Integer.parseInt(strs[index]));
				que.offer(leftNode);
				node.left = leftNode;
			}
			
			++index;
			if(!strs[index].equals("#")){
				TreeNode rightNode = new TreeNode(Integer.parseInt(strs[index]));
				que.offer(rightNode);
				node.right = rightNode;
			}
			
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
		
		TreeNode root = codec.new TreeNode(1);
		root.right = codec.new TreeNode(2);
		
		root = codec.deserialize(codec.serialize(root));
		System.out.println(root.val);
		System.out.println(root.left);
		System.out.println(root.right);
		
		
	}
}
