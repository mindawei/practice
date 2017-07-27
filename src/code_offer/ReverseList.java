package code_offer;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class ReverseList {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode ReverseList(ListNode head) {
		
		if(head==null||head.next==null){
			return head;
		}
		
		ListNode pre = null,cur = head,tmp;
		
		while(cur!=null){
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}
	
}
