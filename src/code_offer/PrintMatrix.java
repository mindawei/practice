package code_offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class PrintMatrix {
	
	public static void main(String[] args) {
		System.out.println(new PrintMatrix().printMatrix(new int[][]{{1}}));
	}
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> ls = new ArrayList<>();
		if(matrix==null){
			return ls;
		}
		
		int leftBoud = -1,rightBound = matrix[0].length,upperBoud = 0,bootomBound = matrix.length;
		int i=0,j=0;
		
		boolean add = false;
		while(true){
		
			while(j<rightBound){
				add = true;
				ls.add(matrix[i][j++]);
			}
			--rightBound;
			--j;
			++i;
			
			if(!add){
				break;
			}
			add = false;
			
			
			while(i<bootomBound){
				add = true;
				ls.add(matrix[i++][j]);
			}
			--bootomBound;
			--i;
			--j;
			
			if(!add){
				break;
			}
			add = false;
			
			while(j>leftBoud){
				add = true;
				ls.add(matrix[i][j--]);
			}
			++leftBoud;
			++j;
			--i;
			
			if(!add){
				break;
			}
			add = false;
			
			while(i>upperBoud){
				add = true;
				ls.add(matrix[i--][j]);
			}
			++upperBoud;
			++i;
			++j;
			
			if(!add){
				break;
			}
			add = false;
		}
		return ls;
    }
	
}
