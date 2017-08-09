package code.leetcode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * https://www.nowcoder.com/practice/86343165c18a4069ab0ab30c32b1afd0?tpId=46&tqId=29069&rp=2&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月9日
 * @Description
 */
public class SortedListToBST {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode sortedListToBST(ListNode head) {
        
    	if(head==null){
    		return null;
    	}else if(head.next==null){
    		return new TreeNode(head.val);
    	}else{
    		
    		ListNode pre = null;
    		ListNode pSlow = head;
    		ListNode pFast = head.next;
    		
    		while(pFast!=null&&pFast.next!=null){
    			pre = pSlow;
    			pSlow = pSlow.next;
    			pFast = pFast.next.next;
    		}
    		
    		if(pFast!=null){ // 偶数
    			pre = pSlow;
    			pSlow = pSlow.next;
    		}
    		
    		TreeNode node = new TreeNode(pSlow.val);
    		pre.next = null;
    		node.left = sortedListToBST(head);
    		node.right = sortedListToBST(pSlow.next);
    		
        	return node;	
    	}
    	
    }
	
}
