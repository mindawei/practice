package code_offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class DeleteDuplication {
	
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode deleteDuplication(ListNode pHead) {
		
		if(pHead==null){
			return null;
		}
		
		ListNode head = new ListNode(0);
		head.next = pHead;
		
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next = cur.next;
		boolean repeat;
		while(next!=null){
			
			repeat = false;
			while(next!=null && next.val==cur.val){
				next = next.next;
				repeat = true;
			}
			
			if(repeat){
				pre.next = next;
			}else{
				pre = cur;
			}
			
			cur = pre.next;
			if(cur==null){
				break;
			}
			
			next = cur.next;
		}
		
		return head.next;
	}
}
