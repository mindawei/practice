package code.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class Find {
	public boolean Find(int target, int [][] array) {
		if(array==null){
			return false;
		}
		
		int row = array.length;
		if(row==0){
			return false;
		}
		
		int col = array[0].length;
		if(col==0){
			return false;
		}
			
		int i = 0,j=col-1;
		int val;
		while(i<row&&j>=0){
			if((val = array[i][j])==target){
				return true;
			}else if(target>val){
				++i;
			}else{ // target<val
				--j;
			}
		}
		return false;
    }
}
