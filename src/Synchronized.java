
public class Synchronized {
	
	public static synchronized void clazzMethod(int i){
		System.out.println("i:"+i);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void objecrtMethod(int i){
		System.out.println("i:"+i);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Synchronized obj = new Synchronized();
		
	
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				int i = 2;
				obj.objecrtMethod(i);
				
				
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				int i = 1;
				obj.clazzMethod(i);
				//obj.objecrtMethod(i);
			}
		}).start();
		
//		try {
//			new Object().wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//			try {
//				new Object().wait(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	}
	
}
