package code_lintcode;

/**
 * 将两个排序链表合并为一个新的排序链表
 * http://www.lintcode.com/zh-cn/problem/merge-two-sorted-lists/
 * http://www.jiuzhang.com/solutions/merge-two-sorted-lists/
 * 
 * @author 闵大为
 * @data 2017年7月28日
 * @Description
 */
public class MergeTwoLists {
	
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int val) {
	          this.val = val;
	          this.next = null;
	      }
	  }
	  
	
	/**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	if(l1==null){
    		return l2;
    	}
    	if(l2==null){
    		return l1;
    	}
    	
    	ListNode p1  = l1;
    	ListNode p2  = l2;
    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	
    	while(p1!=null&&p2!=null){
    		if(p1.val<p2.val){
    			tail.next = p1;
    			tail = p1;
    			p1 = p1.next;
    		}else{
    			tail.next = p2;
    			tail = p2;
    			p2 = p2.next;
    		}
    	}
    	
    	if(p1!=null){
    		tail.next = p1;
    	}
    	
    	if(p2!=null){
    		tail.next = p2;
    	}
    	
    	return head.next;
    }
}
