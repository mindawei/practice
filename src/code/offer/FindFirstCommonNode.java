package code.offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class FindFirstCommonNode {
	
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 
    	int len1 = getLen(pHead1);
    	int len2 = getLen(pHead2);
    	
    	ListNode p1,p2;
    	
    	int k = Math.abs(len1-len2);
    	
    	if(len1>len2){
    		p1 = pHead1;
    		p2 = pHead2;
    	}else{
    		p2 = pHead1;
    		p1 = pHead2;
    	}
    	
    	while(k>0){
    		p1 = p1.next;
    		--k;
    	}
    	
    	while(p1!=p2){
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	
    	return p1;
    }
    
    private int getLen(ListNode head){
    	ListNode p = head;
    	int len  = 0;
    	while(p!=null){
    		p = p.next;
    		++len;
    	}
    	return len;
    }
	
}
