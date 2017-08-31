package company.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for(int i=0;i<n;++i){
			num[i] =sc.nextInt();
		}
		int k = sc.nextInt();
		
		
		Map<Integer,Integer> map = new HashMap<>();
		Map<Integer,Integer> map2 = new HashMap<>();
		map.put(0, 0);
		
		int max = 0;
		for(int i=0;i<n;++i){
			int v = num[i]%k;
			map2.clear();
			for(Map.Entry<Integer, Integer> e : map.entrySet()){
				int ys = e.getKey();
				int m = e.getValue();
				map2.put((ys+v)%k, m+1);
			}
			if(!map2.containsKey(v)){
				map2.put(v, 1);
			}
			
			if(map2.containsKey(0)){
				max = Math.max(max,map2.get(0));
			}
			
			Map<Integer,Integer> tmp = map;
			map = map2;
			map2 = tmp;
		}
		
		System.out.println(max);
	}
}