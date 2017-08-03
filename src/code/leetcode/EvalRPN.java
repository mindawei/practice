package code.leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * https://www.nowcoder.com/practice/22f9d7dd89374b6c8289e44237c70447?tpId=46&tqId=29031&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author mindw
 * @date 2017年8月3日
 */
public class EvalRPN {
	public int evalRPN(String[] tokens) {
		if(tokens==null){
			return 0;
		}
	
		Stack<Integer> stack = new Stack<>();
		
		int a,b;
		for(String token : tokens){
			// +,-,*,/
			if(token.equals("+")){
				b = stack.pop();
				a = stack.pop();
				stack.push(a+b);
			}else if(token.equals("-")){
				b = stack.pop();
				a = stack.pop();
				stack.push(a-b);
			}else if(token.equals("*")){
				b = stack.pop();
				a = stack.pop();
				stack.push(a*b);
			}else if(token.equals("/")){
				b = stack.pop();
				a = stack.pop();
				stack.push(a/b);
			}else{
				stack.push(Integer.parseInt(token));
			}
		}
		
		return stack.pop();    
	}
}
