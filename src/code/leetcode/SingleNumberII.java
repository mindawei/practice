package code.leetcode;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note: 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * https://www.nowcoder.com/practice/1097ca585245418ea2efd0e8b4d9eb7a?tpId=46&tqId=29043&rp=1&ru=/ta/leetcode&qru=/ta/leetcode/question-ranking
 * 
 * @author 闵大为
 * @data 2017年8月6日
 * @Description
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
        
    	if(A==null||A.length==0){
    		return -1;
    	}
    	
    	int[] bits = new int[32];
    	int ans = 0;
    	for (int i = 0; i < 32; ++i) {
    		for (int a : A) {
				bits[i] = (bits[i] + ((a >>> i) & 1)) % 3;
			}
    		ans |= (bits[i] << i); 
		}
    	return ans;
    }
}
