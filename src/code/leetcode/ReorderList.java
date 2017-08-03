package code.leetcode;

/**
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 * reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * 
 * @author 闵大为
 * @data 2017年8月3日
 * @Description
 */
public class ReorderList {
	
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		node1.next = node3;
		node3.next = node2;
		
		
		new ReorderList().reorderList(node1);
		
		while(node1!=null){
			System.out.print(node1.val+" ");
			node1 = node1.next;
		}
		System.out.println();

	}
	
	public void reorderList(ListNode head) {
		if(head==null||head.next==null){
			return;
		}
		
		// 1 break into 2 parts
		ListNode pSlow = head;
		ListNode pFast = head.next;
		
		while(pFast!=null&&pFast.next!=null){
			pSlow = pSlow.next;
			pFast = pFast.next.next;
		}
		
		ListNode p0 = head;
		ListNode p1 = pSlow.next;
		pSlow.next = null;
		
		// 2 reverse p1;
		
		p1 = reverse(p1);
	
		// merge
		ListNode pHead = new ListNode(0);
		ListNode tatil = pHead;
		
		while(p1!=null){
			tatil.next = p0;
			p0 = p0.next;
			tatil = tatil.next;
			
			tatil.next = p1;
			p1 = p1.next;
			tatil = tatil.next;
		}
		tatil.next = p0;
	}
	
	
	private ListNode reverse(ListNode pNode){
		
		ListNode pre = null;
		ListNode cur = pNode;
		ListNode tmp;
		while(cur!=null){
			
			tmp = cur.next;
			cur.next = pre;
			
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}
	
	
}
