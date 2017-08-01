package code.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class ReOrderArray {
	
	public static void main(String[] args) {
		int[] array = {2,4,6,1,3,5,7};
		new ReOrderArray().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
	
	public void reOrderArray(int [] array) {
		if(array==null){
			return;
		}
		
		int n = 0;
		for(int i=0;i<array.length;++i){
			if((array[i]&1)==1){ // 奇数
				int tmp = array[i];
				for(int j=i;j>n;--j){
					array[j] = array[j-1];
				}
				array[n] = tmp;
				++n;
			}
		}
		
    }
}
