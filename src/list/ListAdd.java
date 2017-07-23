package list;

public class ListAdd {

	private static final class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
	
	public static void main(String[] args) {
		//  92468
		//  13579
	
		// 106047
		
		Node[] nodes1 = new Node[5];
		Node[] nodes2 = new Node[5];
		int v0 = 0;
		int v1 = 1;
		
		for(int i=0;i<5;++i){
			nodes1[i] = new Node(v0);
			v0+=2;
			nodes2[i] = new Node(v1);
			v1+=2;
		}
		
		for(int i=0;i<4;++i){
			nodes1[i].next = nodes1[i+1];
			nodes2[i].next = nodes2[i+1];
		}
		nodes1[0].data = 9;
		
		print(nodes1[0]);
		
		print(nodes2[0]);
		
		print(add(nodes1[0], nodes2[0]));
		
	}
	
	private static Node add(Node h0,Node h1){
		
		h0 = reverse(h0);
		h1 = reverse(h1);
		
		int len0 = len(h0);
		int len1 = len(h1);
		
		Node p0,p1;
		
		if(len1>len0){
			p0 = h1;
			p1 = h0;
		}else{
			p0 = h0;
			p1 = h1;
		}
		
		Node head = p0;
		int jw = 0;
		int sum;
		Node pre = null;
		while(p1!=null){
			sum = p0.data + p1.data + jw;
			jw = sum / 10;
			sum %= 10;
			
			p0.data = sum;
			pre = p0;
			
			p0 = p0.next;
			p1 = p1.next;
		}
		
		while(jw!=0){
			if(p0!=null){
				sum = p0.data + jw;
				jw = sum / 10;
				sum %= 10;
				
				p0.data = sum;
				pre = p0;
				p0 = p0.next;
			}else{
				pre.next = new Node(jw);
				break;
			}
		}
	
		return reverse(head);
	}
	
	
	private static int len(Node head){
		Node p = head;
		int len = 0;
		while(p!=null){
			++len;
			p = p.next;
		}
		return len;
	}
	
	private static Node reverse(Node head) {
		
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
