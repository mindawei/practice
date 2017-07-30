package code_offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月30日
 * @Description
 */
public class InversePairs {

	public int InversePairs(int[] array) {
		if (array == null || array.length <= 1) {
			return 0;
		}
		return mergeSort(array, 0, array.length - 1, new int[array.length]);
	}

	private int mergeSort(int[] array, int i, int j, int[] tmp) {
		if (i < j) {
			int mid = (i + j) >>> 1;
		
			int left = mergeSort(array, i, mid, tmp) % 1000000007;
			int right = mergeSort(array, mid + 1, j, tmp)% 1000000007;
			int merge = merge(array, i, mid, j, tmp) % 1000000007;
			return ( left + right + merge) % 1000000007;
		}
		return 0;
	}

	private int merge(int[] array, int bg, int mid, int ed, int[] tmp) {

		int pi = mid;
		int pj =  ed;
		int k =  ed;

		int num = 0;
		while (pi >= bg && pj >= mid + 1) {
			if (array[pi] > array[pj]) {
				num += (pj - mid);
				  if(num>=1000000007){//数值过大求余
					  num%=1000000007;
	                }
				tmp[k--] = array[pi--];
			} else {
				tmp[k--] = array[pj--];
			}
		}

		while (pi >= bg) {
			tmp[k--] = array[pi--];
		}

		while (pj >= mid + 1) {
			tmp[k--] = array[pj--];
		}
		
		for(k=bg;k<=ed;++k){
			array[k] = tmp[k];
		}
		
		return num;
	}

}
