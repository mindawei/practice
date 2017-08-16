package sort;

import java.util.Arrays;

public class Heap2 {
	
	int[] arr;
	int n = 0;
	
	public Heap2(int[] array){
		this.arr = array;
		this.n = array.length;
		System.out.println(Arrays.toString(arr));
		initHeap();
		System.out.println("initHeap:"+Arrays.toString(arr));
	}

	

	private void initHeap() {
		for(int i=(n>>>1)-1;i>=0;--i){
			shiftDown(i);
		}
	}
	
	private void shiftDown(int i){
		int val = arr[i];
		while(i<n){
			int minChild = (i<<1)+1;
			if(minChild>=n){
				break;
			}
			int right = minChild+1;
			if(right<n && arr[right]<arr[minChild]){
				minChild = right;
			}
			
			if(arr[minChild]>val){
				break;
			}else{
				arr[i] = arr[minChild];
				i = minChild;
			}
		}
		arr[i] = val;
	}
	
	private void shiftUp(int i){
		int val = arr[i];
		while(i>0){
			int parent = (i-1)>>>1;
			if(arr[parent]>val){
				arr[i] = arr[parent];
				i = parent;
			}else{
				break;
			}
		}
		arr[i] = val;
	}
	
	private int pop() {
		int val = arr[0];
		arr[0] = arr[n-1];
		--n;
		shiftDown(0);
		return val;
	}

	private void add(int val) {
		if(n==arr.length){
			arr = Arrays.copyOf(arr, n+1);
		}
		arr[n] = val;
		++n;
		shiftUp(n-1);
	}
	
	private void delete(int val) {
		if(n>0){
			delete(val,0);
		}
	}
	
	/** 删除指定的值 */
	private void delete(int val,int i){
		if(i>=n || val<arr[i]){
			return;
		}else if(arr[i]==val){
			if(i==n-1){
				--n;
				return;
			}
			arr[i] = arr[n-1];
			--n;
			shiftUp(i);
			shiftDown(i);
			return;
		}else{
			delete(val,(i<<1)+1);
			delete(val,(i<<1)+2);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {7,6,5,4,8,9,1,2,3};
		// [1, 2, 5, 3, 8, 9, 7, 4, 6]
		Heap2 heap = new Heap2(arr);
		heap.add(0);
//		
		heap.delete(3);
		heap.delete(2);
		
		for(int i=0;i<5;++i){
			System.out.println(heap.pop());
		}
	}



	

}
