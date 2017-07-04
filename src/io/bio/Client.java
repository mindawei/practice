package io.bio;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	public static void main(String[] args) {

		Runnable client = () -> {
			try {
				Socket socket = new Socket("127.0.0.1", 8088);

				OutputStream out = socket.getOutputStream();
				BufferedWriter br = new BufferedWriter(new OutputStreamWriter(out));

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//while(true){
					for (int i = 0; i < 10; ++i) {
						br.write("hello " + i);
					}
					br.close();
				//}

			} catch (IOException e) {
				e.printStackTrace();
			}
		};

		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(client);
		
		//DispatcherServlet d = new DispatcherServlet();
	}
}
