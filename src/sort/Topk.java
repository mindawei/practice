package sort;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Topk {
	public static void main(String[] args) {
		Random random = new Random();
		
		int num = 10;
		List<Integer> ls = Stream.generate(()->random.nextInt(100)).limit(num).collect(Collectors.toList());
		
		int[] arr = new int[num];
		for(int i=0;i<num;++i){
			arr[i] = ls.get(i);
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString(topK(arr,5)));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	/**
	 * 利用快排
	 * 时间： 最坏 O(kn） 最好 O(n)
	 * 空间： 堆 O(1)
	 */
	private static int[] topK(int[] arr, int k) {
		
		if(arr==null||k<0||k>arr.length){
			return null;
		}
		
		topK(arr,0,arr.length-1,k);
		return Arrays.copyOfRange(arr, 0, k);
	}

	private static void topK(int[] arr, int bg, int end, int k) {
		
		if(bg>=end){
			return;
		}
		
		int pos = partion(arr,bg,end);
		int num = pos - bg + 1;
		if(num==k){
			return;
		}else if(num<k){
			topK(arr,pos+1,end,k-num);
		}else{
			topK(arr,bg,pos-1,k);
		}
		
		
	}

	private static int partion(int[] arr, int bg, int end) {
		int val = arr[bg];
		int i = bg;
		int j = end;
		while(i<j){
			while(i<j&&arr[j]>=val){
				--j;
			}
			arr[i] = arr[j];
			while(i<j&&arr[i]<=val){
				++i;
			}
			arr[j] = arr[i];
		}
		arr[i] = val;
		
		return i;
	}
	
	

	/**
	 * 使用最大堆 
	 * 时间： O(nlogK）
	 * 空间： 堆 O(k)
	 */
	private static int[] topK2(int[] arr, int k) {
		
		if(arr==null||k<0){
			return null;
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1,i2)->{
			return i2-i1;
		});
		
		for(int v : arr){
			maxHeap.add(v);
			if(maxHeap.size()>k){
				maxHeap.poll();
			}
		}
		
		int[] topK = new int[k];
		for(int i=0;i<k;++i){
			topK[i] = maxHeap.poll();
		}
		
		return topK;
	}
	
	
	

//	private static int[] topK(int[] arr,int k) {
//		return topK(arr, 0,arr.length-1,k);
//	}
//	
//	private static int[] topK(int[] arr,int left,int right,int k) {
//		int pos = quickSort(arr, left, right);
//		if(pos==k){
//			return Arrays.copyOfRange(arr,0,pos);
//		}else if(pos<k){
//			return topK(arr, pos+1, right,k);
//		}else{ // pos>k
//			return topK(arr, left, pos-1,k);
//		}
//	}
//
//	private static int quickSort(int[] arr, int left, int right) {
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
//		
//		return left;
//	}
}
