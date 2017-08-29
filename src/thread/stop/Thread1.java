package thread.stop;

public class Thread1 extends Thread {
	public void run(){
        super.run();
        for(int i=0; i<500000; i++){
            if(this.interrupted()) {
                System.out.println("线程已经终止， for循环不再执行");
                break;
            }
            System.out.println("i="+(i+1));
        }
    }

	    public static void main(String args[]){
	        Thread thread = new Thread1();
	        thread.start();
	        try {
	            Thread.sleep(100);
	            thread.interrupt();
	        } catch (InterruptedException e) {
	        	   System.out.println("stop");
	            e.printStackTrace();
	        }
	    }
}