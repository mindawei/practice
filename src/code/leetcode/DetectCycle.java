package code.leetcode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up: Can you solve it without using extra space?
 * 
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=46&tqId=29039&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月5日
 * @Description
 */
public class DetectCycle {

	 class ListNode {
		   int val;
		   ListNode next;
		   ListNode(int x) {
		       val = x;
		       next = null;
		   }
		 }
	
	 
	  public ListNode detectCycle(ListNode head) {
	        
		  if(head==null||head.next==null){
			  return null;
		  }
		  
		  // find the commom node 
		  ListNode pSlow = head;
		  ListNode pFast = head.next;
		  
		  while(pFast!=null && pFast.next!=null){
			  
			  if(pFast==pSlow){
				  break;
			  }
			  
			  pFast = pFast.next.next;
			  pSlow = pSlow.next;
		  }
		  
		  if(pFast!=pSlow){
			  return null;
		  }
		  
		  // calculate cycle length
		  int len = 1;
		  pFast = pFast.next;
		  while(pFast!=pSlow){
			  ++len;
			  pFast = pFast.next;
		  }
		  
		  // move pFast len step
		  pSlow = head;
		  pFast = head;
		  while(len>0){
			  --len;
			  pFast = pFast.next;
		  }
		  
		  
		  while(pFast!=pSlow){
			  pFast = pFast.next;
			  pSlow = pSlow.next;
		  }
		  
		  return pFast;
	    }
}
