package sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {
	
	public static void main(String[] args) {
		Random random = new Random();
		
		int num = 10;
		List<Integer> ls = Stream.generate(()->random.nextInt(100)).limit(num).collect(Collectors.toList());
		
		int[] arr = new int[num];
		for(int i=0;i<num;++i){
			arr[i] = ls.get(i);
		}
		System.out.println(Arrays.toString(arr));
		quickSort(arr);
		//quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void quickSort(int[] arr) {
		if(arr==null||arr.length<=1){
			return;
		}
		quickSort(arr,0,arr.length-1);
	}

	private static void quickSort(int[] arr, int bg, int ed) {
		if(bg<ed){
			int pos = partion(arr,bg,ed);
			quickSort(arr,bg,pos);
			quickSort(arr,pos+1,ed);
		}
	}

	private static int partion(int[] arr, int i, int j) {
		
		int val = arr[i];
		
		while(i<j){
			
			while (i < j && arr[j] >= val) {
				--j;
			}
			arr[i] = arr[j];
			
			while (i < j && arr[i] <= val) {
				++i;
			}
			arr[j] = arr[i];
		}
		arr[i] = val;
		return i;
	}
	
	

//	private static void quickSort(int[] arr) {
//		if(arr==null||arr.length<=1){
//			return;
//		}
//		quickSort(arr,0,arr.length-1);
//	}
//
//	private static void quickSort(int[] arr, int bg, int end) {
//		if(bg<end){
//			int pos = partion(arr,bg,end);
//			quickSort(arr,bg,pos);
//			quickSort(arr,pos+1,end);
//		}	
//	}
//
//	private static int partion(int[] arr, int i, int j) {
//		int val = arr[i];
//		while(i<j){
//			while(i<j&&arr[j]>=val){
//				--j;
//			}
//			arr[i] = arr[j];
//			
//			while(i<j&&arr[i]<=val){
//				++i;
//			}
//			arr[j] = arr[i];
//		}
//		arr[i] = val;
//		return i;
//	}
	
	
	

//	private static void quickSort(int[] arr) {
//		if(arr==null||arr.length<=1){
//			return;
//		}
//		quickSort(arr,0,arr.length-1);
//	}
//	
//	private static void quickSort(int[] arr,int bg,int end) {
//		if(bg>=end){
//			return;
//		}
//		int pos = partion(arr,bg,end);
//		
//		quickSort(arr,bg,pos);
//		quickSort(arr,pos+1,end);
//	}
//
//	private static int partion(int[] arr, int bg, int end) {
//		int val = arr[bg];
//		int i= bg;
//		int j = end;
//		while(i<j){
//			while(i<j&&arr[j]>=val){
//				--j;
//			}
//			arr[i] = arr[j];
//			while(i<j&&arr[i]<=val){
//				++i;
//			}
//			arr[j] = arr[i];
//		}
//		arr[i] = val;
//		return i;
//	}
//	

	
//	private static void quickSort(int[] arr) {
//		if(arr==null || arr.length<=1){
//			return;
//		}
//		quickSort(arr,0,arr.length-1);
//	}
//
//	private static void quickSort(int[] arr, int bg, int end) {
//		
//		if(bg>=end){
//			return;
//		}
//		
//		int pos = partion(arr,bg,end);
//		
//		quickSort(arr,bg,pos);
//		quickSort(arr,pos+1,end);
//		
//	}
//
//
//	private static int partion(int[] arr, int bg, int end) {
//		
//		int val = arr[bg];
//		int i = bg;
//		int j = end;
//		
//		while(i<j){
//			while(i<j&&arr[j]>=val){
//				j--;
//			}
//			arr[i] = arr[j];
//			while(i<j&&arr[i]<=val){
//				i++;
//			}
//			arr[j] = arr[i];
//		}
//		arr[i] = val;
//		return i;
//	}
	
//	private static void quickSort(int[] arr,int left,int right) {
//		if(left>=right){
//			return;
//		}
//		int pos = quickSortOne(arr, left, right);
//		quickSort(arr, left, pos-1);
//		quickSort(arr, pos+1, right);
//		
//	}
//
//	private static int quickSortOne(int[] arr, int left, int right) {
//		int val = arr[left];
//		while(left<right){
//			while( left<right && arr[right]>=val){
//				right--;
//			}
//			arr[left] = arr[right];
//			while( left<right && arr[left]<=val){
//				left++;
//			}
//			arr[right] = arr[left];
//		}
//		arr[left] = val;
//		return left;
//	}
}
