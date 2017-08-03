package code.leetcode;

/**
 * Sort a linked list using insertion sort.
 * https://www.nowcoder.com/practice/152bc6c5b14149e49bf5d8c46f53152b?tpId=46&tqId=29034&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 *
 * @author mindw
 * @date 2017年8月3日
 */
public class InsertionSortList {
	
	 public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	      val = x;
	      next = null;
	    }
	}
	
	
	public ListNode insertionSortList(ListNode head) {
	     
		ListNode cur = head;
		ListNode node;
		while(cur!=null){
			
			node = head;
			int val = cur.val;
			while(node!=cur&&node.val<val){
				node = node.next;
			}
		
			int preVal = val;
			while(node!=cur){
				
				val = node.val;
				node.val = preVal;
				preVal = val;
				
				node = node.next;
			}
			
			node.val = preVal;
			cur = cur.next;
		}
		
		return head;
	}
}
