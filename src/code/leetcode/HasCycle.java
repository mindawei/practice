package code.leetcode;


/**
 * Given a linked list, determine if it has a cycle in it.Follow up:Can you solve it without using extra space?
 * 
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=46&tqId=29039&rp=1&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking&tPage=1
 * 
 * @author 闵大为
 * @data 2017年8月5日
 * @Description
 */
public class HasCycle {
	
	
	 class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) {
	       val = x;
	       next = null;
	   }
	 }
	
	   
	   public boolean hasCycle(ListNode head) {
		   if(head==null||head.next==null){
			   return false;
		   }
		   
		   ListNode pSlow = head;
		   ListNode pFast = head.next;
		   
		   while(pFast!=null&&pFast.next!=null){
			   
			   if(pSlow==pFast){
				   return true;
			   }
			   
			   pSlow = pSlow.next;
			   pFast = pFast.next.next;
		   }
		   
		   return false;
	   }
}
