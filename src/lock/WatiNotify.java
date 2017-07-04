package lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Easy result in dead lock
public class WatiNotify {
	
	public static void main(String[] args) {
	
		Object obj = new Object();
		
		Runnable r1 = ()->{
			synchronized (obj) {
				try {
					System.out.println("r1 0");
					obj.wait();
					System.out.println("r1 1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable r2 = ()->{
			synchronized (obj) {
				System.out.println("r2 0");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				obj.notify();
		
				System.out.println("r2 1");
			}
		};
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(r2);
		executor.execute(r1);
		System.out.println("done!");
		
	}

}
