package code.offer;

import java.util.ArrayList;

public class PrintListFromTailToHead {
	
	    public class ListNode {
	        int val;
	        ListNode next = null;
	
	        ListNode(int val) {
	            this.val = val;
	        }
	    }

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> ls = new ArrayList<>();
		_printListFromTailToHead(listNode, ls);
		return ls;
    }
	
	private void  _printListFromTailToHead(ListNode listNode,ArrayList<Integer> ls){
		if(listNode!=null){
			_printListFromTailToHead(listNode.next, ls);
			ls.add(listNode.val);
		}
	}
}
