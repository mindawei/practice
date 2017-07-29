package code_offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class VerifySquenceOfBST {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence == null) {
			throw new RuntimeException("参数错误！");
		}

		int n = sequence.length;
		if(n==0){
			return false;
		}

		return check(sequence, 0, n - 1);
	}

	private boolean check(int[] sequence, int left, int right) {
		if (left >= right) {
			return true;
		}

		// find right part > root.val, until left part or null
		int pos = right - 1;
		while (pos >= left && sequence[pos] > sequence[right]) {
			--pos;
		}
		
		// check left part < root.val
		int p = pos;
		while(p>=left){
			if(sequence[p]>sequence[right]){
				return false;
			}
			--p;
		}

		return check(sequence, left, pos) && check(sequence, pos + 1, right - 1);
	}

}
