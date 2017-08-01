package code.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class IsPopOrder {
	
	
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null||popA==null){
    		throw new RuntimeException("参数错误！");
    	}
    	
    	Stack<Integer> st = new Stack<>();
    	int p0 = 0;
    	int p1 = 0;
    	while(p0<pushA.length){
    		
    		st.push(pushA[p0++]);
    		
    		while(!st.isEmpty() && popA[p1]==st.peek()){
    			st.pop();
    			++p1;
    		}
    	}
    	
    	while(!st.isEmpty() && popA[p1]==st.peek()){
			st.pop();
			++p1;
		}
    	
    	return st.isEmpty();
    }
	
}
