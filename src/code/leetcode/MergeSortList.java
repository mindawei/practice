package code.leetcode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * https://www.nowcoder.com/practice/d75c232a0405427098a8d1627930bea6?tpId=46&tqId=29033&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月3日
 */
public class MergeSortList {
	
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
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		new MergeSortList().sortList(node1);
		
	}
	 
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pSlow = head;
		ListNode pFast = head.next;

		while (pFast != null && pFast.next != null) {
			pSlow = pSlow.next;
			pFast = pFast.next.next;
		}

		ListNode p0 = head;
		ListNode p1 = pSlow.next;
		pSlow.next = null;
		
		return merge(mergeSort(p0), mergeSort(p1));
	}

	
	private ListNode merge(ListNode p0, ListNode p1) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while(p0!=null&&p1!=null){
			if(p0.val<p1.val){
				tail.next = p0;
				p0 = p0.next;
			}else{
				tail.next = p1;
				p1 = p1.next;
			}
			tail = tail.next;
		}
		
		if(p0==null){
			tail.next = p1;
		}else{
			tail.next = p0;
		}
		return head.next;
	}
	
}
