package sort;

import java.util.Arrays;

public class Heap {
	
	int[] arr;
	int n = 0;
	
	public Heap(int[] array){
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
	
	private int pop(){
		int val = arr[0];
		arr[0] = arr[n-1];
		n--;
		shiftDown(0);
		System.out.println("after pop:"+Arrays.toString(arr));
		return val;
	}
	
	private void add(int x) {
		if(n==arr.length){
			arr = Arrays.copyOf(arr, n+1);
		}
		arr[n] = x;
		n+=1;
		shiftUp(n-1);
		System.out.println("after add:"+Arrays.toString(arr));
	}

	private void shiftUp(int i) {
		int val = arr[i];
		while(i>0){
			int parent = (i-1)>>>1;
			if(arr[parent]>val){
				arr[i] = arr[parent];
				i=parent;
			}else{
				break;
			}
		}
		arr[i] = val;
	}

	private void shiftDown(int i) {
		int val = arr[i];
		while(i<n){
			int left = (i<<1)+1;
			int right = left+1;
			int minChild = left;
			if(right<n && arr[right]<arr[left]){
				minChild = right;
			}
			if(minChild<n && arr[minChild]<val){
				arr[i] = arr[minChild];
				i = minChild;
			}else{
				break;
			}
		}
		arr[i] = val;
	}

	public static void main(String[] args) {
		int[] arr = {7,6,5,4,8,9,1,2,3};
		Heap heap = new Heap(arr);
		heap.add(0);
		
		for(int i=0;i<5;++i){
			System.out.println(heap.pop());
		}
	}

	

}
