package code_offer;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * @author mindw
 * @date 2017年8月1日
 */
public class EntryNodeOfLoop {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		
		ListNode node = new EntryNodeOfLoop().EntryNodeOfLoop(node1);
		System.out.println(node.val);
		
	}
	
	/**
	 * 参考：
	 * https://www.nowcoder.com/profile/163334/codeBookDetail?submissionId=1512740
	 */
	ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }
	
	public ListNode EntryNodeOfLoop2(ListNode pHead) {
		
		ListNode meetNodeInCycle = getNodeInCycle(pHead);
		if(meetNodeInCycle==null){
			return null;
		}
		
		int len = getCycleLen(meetNodeInCycle);
		ListNode pFast = pHead;
		ListNode pSlow = pHead;
		while(len>0){
			pFast = pFast.next;
			--len;
		}
		
		while(pFast!=pSlow){
			pFast = pFast.next;
			pSlow = pSlow.next;
		}
		return pFast;
	}
	
	private int getCycleLen(ListNode node) {
		if(node==null){
			return 0;
		}
		
		ListNode cur = node;
		node = node.next;
		int len = 1;
		while(node!=cur){
			++len;
			node = node.next;
		}
		return len;
	}

	private ListNode getNodeInCycle(ListNode pHead){
		
		if(pHead==null){
			return null;
		}
		
		ListNode pFast = pHead.next;
		ListNode pSlow = pHead;
		
		while(pFast!=null && pFast.next!=null && pFast!=pSlow){
			pFast = pFast.next.next;
			pSlow = pSlow.next;
		}
		
		if(pFast!=pSlow){
			return null;
		}
		
		return pFast;
	}

}
