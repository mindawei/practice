package code.offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 
 * @author 闵大为
 * @data 2017年7月29日
 * @Description
 */
public class GetLeastNumbers {
	
	public static void main(String[] args) {
		System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},1));;
		
	}
	
	  public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		  
		  ArrayList<Integer> ls = new ArrayList<>();
		  
		  if(input==null||k>input.length||k==0){
			  return ls;
		  }
		  
		  --k;
		  quickSort(input, 0, input.length-1, k);
		  
		  for(int i=0;i<=k;++i){
			  ls.add(input[i]);
		  }
		  return ls;
	  }
	  
	  private void quickSort(int[] input,int i,int j,int k){
		  if(i>=j){
			  return;
		  }
		  
		  int pos = partion(input, i, j);
		  
		  if(pos==k){
			  return;
		  }else if(k>pos){
			  partion(input, pos+1, j);
		  }else{
			  partion(input, i, pos-1);
		  }
		  
	  }
	  

	  

	private int partion(int[] input, int i, int j) {
		int val = input[i];
		while(i<j){
			
			while(i<j&&input[j]>=val){
				--j;
			}
			input[i] = input[j];
			
			
			while(i<j&&input[i]<=val){
				++i;
			}
			input[j] = input[i];
		}
		input[i] = val;
		return i;
	}
}
