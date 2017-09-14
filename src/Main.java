import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println(Math.pow(2+Math.sqrt(3),80)%10);
		
		new HashMap().size();
		
		new HashMap().put("", "");
		
		new TreeMap().get("");
		
		new ConcurrentHashMap<>().size();
		
		new ConcurrentHashMap<>().remove("");
		
		new ConcurrentHashMap<>().put("", "");
	
		new Object();
		
		new ArrayList<>().add("");
		
		new Vector<>().add("");
		
		
		Collections.shuffle(null);
		
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		
		});
		
		new Thread().suspend();
		new Thread().resume();
		new Thread().stop();
		
		new Thread().setDaemon(true);
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		// task.get();
		
		class A implements Collection{

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray(Object[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean add(Object e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean containsAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}
			
		}
		
	}
	
	
	
}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		for(int i=0;i<n;++i){
//			arr[i] = sc.nextInt();
//		}
//		System.out.println(solve(arr));
//	}
//
//	private static String solve(int[] arr) {
//	
//		return null;
//	}
//}
