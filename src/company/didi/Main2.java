package company.didi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
//		String[] strs = sc.nextLine().split(" ");
//		int[] arr = new int[strs.length];
//		
		ArrayList<Integer> ls = new ArrayList<>();
		while(sc.hasNext()){
			ls.add(sc.nextInt());
			if(!sc.hasNextLine()){
				break;
			}
		}
	
		int k = ls.remove(ls.size()-1);
		int[] arr = new int[ls.size()];
		for(int i=0;i<arr.length;++i){
			arr[i] = ls.get(i);
		}
		
		topK(arr,0,arr.length-1,k-1);
		System.out.println(arr[k-1]);
		
	}

	private static void topK(int[] arr, int bg, int ed, int k) {
		if(bg<ed){
			int pos = maxPartion(arr,bg,ed);
			if (pos == k) {
				return;
			} else if (k > pos) {
				topK(arr, pos + 1, ed, k - pos);
			}else{ // k < pos
				topK(arr,bg,pos-1,k);
			}
		}
	}

	private static int maxPartion(int[] arr, int i, int j) {
		int val = arr[i];
		while(i<j){
			while(i<j&&arr[j]<=val){
				--j;
			}
			arr[i] = arr[j];
			while(i<j&&arr[i]>=val){
				++i;
			}
			arr[j] = arr[i];
		}
		arr[i] = val;
		return i;
	}

}
