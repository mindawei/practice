import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
	
	public static void main(String[] args) {
//		HashMap<Integer,Integer> strs = new HashMap<>();
//		int num = 1000;
//		for(int i=0;i<num;++i){
//			strs.put(i, 1);
//		}
//		
//		new Thread(()->{
//			strs.put(num-1, 2);
//		}).start();
//		
//		for(int v : strs.values()){
//			System.out.println(v);
//		}
		

//		System.out.println(10 % 3 * 2);

//		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>(){
//
//			@Override
//			public Integer call() throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//		});

//		
//		class A{
//			synchronized void methodA(){
//				System.out.println('A');
//				try {
//					Thread.sleep(100 * 1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			synchronized void  methodB(){
//				System.out.println('B');
//				try {
//					Thread.sleep(100 * 1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		
//		A a  = new A();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				a.methodB();
//				
//			}
//		}).start();
//	
//	new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				a.methodA();
//				
//			}
//		}).start();
//		
//	CyclicBarrier barrier = new CyclicBarrier(10);
//	
//	CompletionService<Integer> completionService = new ExecutorCompletionService<>(null);

//		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("End!");
//			}
//		}));
//		System.out.println("A");
//	
//		System.identityHashCode(null);

		// true
		// int a=300; int b=300; 
		
		// false  true
		Integer a=30; Integer b=30;
		
		// false
		// Integer a = new Integer(30); Integer b = new Integer(30);
		
		System.out.println(a==b);
		
		
	ExecutorService executors = Executors.newCachedThreadPool();
		
	}
	
}
