package io.bio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	public static void main(String[] args) {
	
		
	Runnable host = ()->{	
			try {
				ServerSocket serverSocket = new ServerSocket(8088);
				Socket socket = serverSocket.accept();
				InputStream in = socket.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				System.out.println("accepted!");
				
					String line;
					while((line=br.readLine())!=null){
						System.out.println(line);
					}
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	};	
		

	ExecutorService service  = Executors.newFixedThreadPool(2);
	service.execute(host);
	
	}
}
