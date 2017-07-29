package code_offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class MinStack {
	
		private final Stack<Integer> data = new Stack<>();
		private final Stack<Integer> min = new Stack<>();
	
		public void push(int node) {
	        data.push(node);
	        if(min.isEmpty()){
	        	min.push(node);
	        }else{
	        	min.push(Math.min(min.peek(), node));
	        }
	    }
	    
	    public void pop() {
	    	
	    	if(data.size()==0){
	    		throw new RuntimeException("栈为空！");
	    	}
	    	
	        data.pop();
	        min.pop();
	    }
	    
	    public int top() {
	    	if(data.size()==0){
	    		throw new RuntimeException("栈为空！");
	    	}
	        return data.peek();
	    }
	    
	    public int min() {
	    	if(min.size()==0){
	    		throw new RuntimeException("栈为空！");
	    	}
	    	 return min.peek();
	    }
}
