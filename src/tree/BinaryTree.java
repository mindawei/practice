package tree;

import java.awt.print.Printable;
import java.util.Stack;

// 先序、中序、后序非递归实现
// http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
public class BinaryTree {
	
	static final class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	
	
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n3.left = n6;
		n3.right = n7;
		
		
		DLR(n1);
		System.out.println();
		
		DLRByStack(n1);
		System.out.println();
		
		System.out.println("-------");
		
		LDR(n1);
		System.out.println();
		
		LDRByStack(n1);
		System.out.println();
		
		System.out.println("-------");
		
		
		LRD(n1);
		System.out.println();
		
		LRDByStack(n1);
		System.out.println();
		
		LRDByStack2(n1);
		System.out.println();
		
		System.out.println("-------");
	}

	private static void LRD(Node node) {
		if(node!=null){
			LRD(node.left);
			LRD(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	private static void LRDByStack(Node node) {
		
		Stack<Node> stack = new Stack<>();
		Stack<Boolean> visited = new Stack<>();
		Node p = node;
		
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				visited.push(false);
				p = p.left;
			}
			
			if(!stack.isEmpty()){
				p = stack.peek();
				if(visited.pop()){
					System.out.print(p.data+" ");
					stack.pop();
					p = null;
				}else{
					visited.push(true);
					p = p.right;
				}
			}
		}
		
	}
	
//	private static void LRDByStack(Node node) {
//		Stack<Node> stack = new Stack<>();
//		Stack<Boolean> isVisited = new Stack<>();
//		Node p = node;
//		
//		while(p!=null||!stack.isEmpty()){
//			
//			while(p!=null){
//				stack.push(p);
//				isVisited.push(false);
//				p = p.left;
//			}
//			
//			if(!stack.isEmpty()){
//				if(isVisited.pop()){ // 访问过
//					System.out.print(stack.pop().data+" ");
//					p = null;
//				}else{ // 没访问过
//					isVisited.push(true);
//					p = stack.peek();
//					p = p.right;
//				}
//			}
//				
//		}
//	}
	
	private static void LRDByStack2(Node node) {
		Stack<Node> stack = new Stack<>();
		Node p = node;
		stack.push(p);
		
		Node pre = null;
		
		while(!stack.isEmpty()){
			p = stack.peek();
			if(( p.left==null&&p.right==null)
					|| (pre!=null &&( p.left == pre || p.right == pre))){
				System.out.print(p.data+" ");
				stack.pop();
				pre = p;
			}else{
				if(p.right!=null){
					stack.push(p.right);
				}
				if(p.left!=null){
					stack.push(p.left);
				}
			}
		}
	}

	private static void LDR(Node node) {
		if(node!=null){
			LDR(node.left);
			System.out.print(node.data+" ");
			LDR(node.right);
		}
	}
	
	private static void LDRByStack(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node p = node;
		while(p!=null || !stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p = p.left;
			}
			
			if(!stack.isEmpty()){
				p = stack.pop();
				System.out.print(p.data+" ");
				p = p.right;
			}
		}
		
	}

//	private static void LDRByStack(Node node) {
//		Stack<Node> stack = new Stack<>();
//		Node p = node;
//		while(p!=null||!stack.isEmpty()){
//			while(p!=null){
//				stack.push(p);
//				p = p.left;
//			}
//			
//			if(!stack.isEmpty()){
//				p = stack.pop();
//				System.out.print(p.data+" ");
//				p = p.right;
//			}
//		}
//	
//	}

	private static void DLR(Node node) {
		if(node!=null){
			System.out.print(node.data+" ");
			DLR(node.left);
			DLR(node.right);
		}
	}
	
	private static void DLRByStack(Node node) {
		Stack<Node> stack = new Stack<>();
		Node p = node;
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				System.out.print(p.data+" ");
				stack.push(p);
				p = p.left;
			}
			
			if(!stack.isEmpty()){
				p = stack.pop().right;
			}
		}
	}
	
	
//	private static void DLRByStack(Node node) {
//		
//		Stack<Node> stack = new Stack<>();
//		Node p = node;
//		
//		while(p!=null||!stack.isEmpty()){
//			
//			while(p!=null){
//				System.out.print(p.data+" ");
//				stack.push(p);
//				p = p.left;
//			}
//			
//			if(!stack.isEmpty()){
//				p = stack.pop();
//				p = p.right;
//			}
//		}
//	}

	
	
	

}
