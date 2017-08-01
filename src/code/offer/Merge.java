package code.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class Merge {
	
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	   public ListNode Merge(ListNode list1,ListNode list2) {
	        
		  ListNode head = new ListNode(0);
		  ListNode tail = head;
		  
		  while(list1!=null&&list2!=null){
			  if(list1.val<list2.val){
				  tail.next = list1;
				  list1 = list1.next;
			  }else{
				  tail.next = list2;
				  list2 = list2.next;
			  }
			  tail = tail.next;
		  }
		   
		  if(list1!=null){
			  tail.next = list1;
		  }else{
			  tail.next = list2;
		  }
		  
		  return head.next;
		   
	    }
}
