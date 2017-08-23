package company.alibaba;

import java.util.*;
public class Main {
	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int pick(int[] peaches) {
    	int[] nums = new int[peaches.length];
    	int max = 0;
    	for(int i=0;i<peaches.length;++i){
    		nums[i] = 1;
    		for(int j=0;j<i;++j){
    			if(peaches[j]<peaches[i]){
    				nums[i] = Math.max(nums[i], nums[j]+1);
    			}
    		}
    		max = Math.max(max, nums[i]);
    	}
    	return max;
    }
    
    // 10 4 5 12 8
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int trees = in.nextInt();
        int[] peaches = new int[trees];
        for (int i = 0; i < peaches.length; i++) {
            peaches[i] = in.nextInt();
        }
        System.out.println(pick(peaches));
    }
}
