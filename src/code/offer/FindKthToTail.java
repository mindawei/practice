package code.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class FindKthToTail {
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null||k<=0){
			return null;
		}
		
		ListNode pfast = head;
		
		while(k>0&&pfast!=null){
			--k;
			pfast = pfast.next;
		}
		
		if(k>0){
			return null;
		}
		
		ListNode pslow = head;
		while(pfast!=null){
			pfast = pfast.next;
			pslow = pslow.next;
		}
		
		return pslow;
	}
}
