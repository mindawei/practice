package code.leetcode;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * 
 * https://www.nowcoder.com/practice/60e43001345241ba9266cb4ee6fc6350?tpId=46&tqId=29042&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class CopyRandomList {
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	 };
	
	
	 public RandomListNode copyRandomList(RandomListNode pHead) {
	        if(pHead==null){
	    		return null;
	    	}
	    	
	    	HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
	    	
	    	RandomListNode p0 = pHead;
	    	
	    	RandomListNode head = new RandomListNode(0);
	    	RandomListNode p1 = head;
	    	
	    	RandomListNode node;
	    	while(p0!=null){
	    		node = new RandomListNode(p0.label);
	    		map.put(p0, node);
	    		
	    		p0 = p0.next;
	    		
	    		p1.next = node;
	    		p1 = p1.next;
	    	}
	    	
	    	p0 = pHead;
	    	p1 = head.next;
	    	while(p0!=null){
	    		if(p0.random!=null){
	    			p1.random = map.get(p0.random);
	    		}
	    		p0 = p0.next;
	    		p1 = p1.next;
	    	}
	    
	    	return head.next;
	    }
}
