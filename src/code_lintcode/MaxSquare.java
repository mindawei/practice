package code_lintcode;

/**
 * 在一个二维01矩阵中找到全为1的最大正方形
 * http://www.lintcode.com/zh-cn/problem/maximal-square/
 * http://www.jiuzhang.com/solutions/maximal-square/
 * 
 * @author mindw
 * @date 2017年7月28日
 */
public class MaxSquare {
	/**
	 * @param matrix:
	 *            a matrix of 0 and 1
	 * @return: an integer
	 */
	public int maxSquare(int[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int r = matrix.length;
		int c = matrix[0].length;

		int[][] ans = new int[r][c];

		int max = 0;
		for (int i = 0; i < r; ++i) {
			if ((ans[i][0] = matrix[i][0]) == 1) {
				max = 1;
			}
		}

		for (int i = 0; i < c; ++i) {
			if ((ans[0][i] = matrix[0][i]) == 1) {
				max = 1;
			}
		}

		int size;
		for (int i = 1; i < r; ++i) {
			for (int j = 1; j < c; ++j) {
				
				size = ans[i-1][j-1];
				int off;
				for (off = 0; off <= size; ++off) {
					if (matrix[i - off][j] != 1 || matrix[i][j - off] != 1) {
						break;
					}
				}
				
				if ((ans[i][j] = off) > max) {
					max = off;
				}
			}
		}

		return max*max;
	}
}
