package code_offer;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class CloneRandomListNode {
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
    public RandomListNode Clone(RandomListNode pHead){
    	
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
