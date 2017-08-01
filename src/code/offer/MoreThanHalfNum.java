package code.offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class MoreThanHalfNum {
	
	public static void main(String[] args) {
		System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3}));
	}
	
	   public int MoreThanHalfNum_Solution(int [] array) {
		   if(array==null||array.length==0){
			   throw new RuntimeException("Invalid Parameter!");
		   }
		   
		   int targetPos = (array.length>>>1);
		   find(array,0,array.length-1);
		   
		   int num = 1;
		   int val = array[targetPos];
		   for(int i=targetPos-1;i>=0;--i){
			   if(array[i]==val){
				   ++num;
			   }
		   }
		   
		   for(int i=targetPos+1;i<array.length;++i){
			   if(array[i]==val){
				   ++num;
			   }
		   }
		   
		   if(num>targetPos){
			   return val;
		   }else{
			   return 0;
		   }
		   
	   }

	private int find(int[] array, int bg, int ed){
		if(bg==ed){
			return array[bg];
		}
		int pos = partion(array,bg,ed);
		int mid = array.length>>>1;
		if(pos==mid){
			return array[pos];
		}else if(pos>mid){
			return find(array, bg, pos-1);
		}else{ // pos < mid
			return find(array, pos+1, ed);
		}
	}

	private int partion(int[] array, int i, int j) {
		int val = array[i];
		while(i<j){
			
			while(i<j&&array[j]>=val){
				--j;
			}
			array[i] = array[j];
			
			while(i<j&&array[i]<=val){
				++i;
			}
			array[j] = array[i];
		}
		array[i] = val;
		return i;
	}
}
