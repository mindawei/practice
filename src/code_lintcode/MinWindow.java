package code_lintcode;

import java.util.HashMap;

public class MinWindow {
	
	public static void main(String[] args) {
		System.out.println(minWindow("asdfadfaidyfaksdhadhfadufaoidfadfbadf", "asfadbd"));
		System.out.println(minWindow("", ""));
		
	}
	 /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public static String minWindow(String source, String target) {
    	
    	if(source.length()<target.length()||source.length()==0||target.length()==0){
    		return "";
    	}
		
        HashMap<Character,Integer> nums = new HashMap<>();
        HashMap<Character,Integer> existNums = new HashMap<>();
        
        int minLen = Integer.MAX_VALUE;
        int n = target.length();
        for(char ch : target.toCharArray()){
        	if(nums.containsKey(ch)){
        		nums.put(ch, nums.get(ch)+1);
        	}else{
        		nums.put(ch, 1);
        	}
        }
        
        int i=-1;int j=0;
        int left=0;int right =0;
        int len = source.length();
        char ch;int existNum, num;
        boolean next;
        
        while(right<len){
        	
        	ch = source.charAt(right);
        	
        	if(nums.containsKey(ch)){
        		
        		num = nums.get(ch);
        		existNum = existNums.containsKey(ch)? existNums.get(ch):0;
        		existNums.put(ch, existNum+1);
        		if(existNum<num){
        			--n;	
        		}
       
        		if(n==0){
        			for(;;){
        				next = false;
        				ch = source.charAt(left);
        				
        				if(nums.containsKey(ch)){
        					existNum = existNums.containsKey(ch)? existNums.get(ch):0;
        					if(existNum > nums.get(ch)){
        						existNums.put(ch, existNum-1);
        						next =true;
        					}
        				}else{
    						next =true;
        				}
        				
        				if(next){
        					++left;
        				}else{
        					break;
        				}
        			}
        			if(right-left+1<minLen){
        				minLen = right-left+1;
        				i = left;
        				j = right;
        			}
        		}
        	}
        	++right;
        }
        
        if(i==-1){
        	return "";
        }else{
        	return source.substring(i, j+1);
        }
    }
}
