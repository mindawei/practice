package list;

public class LinkedList {

	private static final class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	
	public static void main(String[] args) {
		
		Node[] nodes = new Node[10];
		
		for(int i=0;i<10;++i){
			nodes[i] = new Node(i);
		}
		
		for(int i=0;i<9;++i){
			nodes[i].next = nodes[i+1];
		}
		
		print(nodes[0]);
		
		print(swap(nodes[0]));
		
	}

	private static Node swap(Node head) {
		
		if(head==null){
			return head;
		}
		
		Node p0=null,p1 = head,p2=null;
		while(p1!=null){
			p2 = p1.next;
			p1.next = p0;
			p0 = p1;
			p1 = p2;
		}
		
		return p0;
	}

	private static void print(Node head) {
		Node node = head;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
	
}
