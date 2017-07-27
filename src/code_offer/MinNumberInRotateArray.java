package code_offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author 闵大为
 * @data 2017年7月27日
 * @Description
 */
public class MinNumberInRotateArray {
	 public int minNumberInRotateArray(int [] array) {
		 if(array==null||array.length==0){
			 throw new RuntimeException("参数错误");
		 }
		 
		 int i = 0;
		 int j = array.length -1;
		 int mid = i;
		 while(array[i]>=array[j]){
			 
			 if(j-i==1){
				  mid = j;
				  break;
			 }
			 
			mid = (i+j) >> 1;
		 
		 	if(array[i]==array[j]
		 			&&array[mid]==array[i]){
		 		
		 		int result = array[i];
		 		for(int p = i+1;p<=j;++p){
		 			if(array[p]<result){
		 				result = array[p];
		 			}
		 		}
		 		return result;
		 	}
		 
		 
		 	if(array[mid]>=array[i]){
		 		i = mid;
		 	}else{ 
		 		j = mid;
		 	}
		
		 }
		
		 return array[mid];
	 }
	 
	 
	 
}
