package networking.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args)  {
		
//		try(ServerSocket server = new ServerSocket(9000);
//				
//				Socket client = server.accept();
//				BufferedReader in = new BufferedReader(
//						new InputStreamReader(client.getInputStream()));
//				PrintWriter out =  new PrintWriter(client.getOutputStream(),true);
//		){
//			System.out.println("Connected...");
//			System.out.println("accepted socket port:" + client.getPort());
//			String line ="";
//			while((line = in.readLine()) !=null){
//				out.println("You said: " + line);
//			}
//			
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		
		try (ServerSocket server = new ServerSocket(9000)) {
			while(true){
				try(
						Socket client = server.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
						PrintWriter out =  new PrintWriter(client.getOutputStream(),true);){
					System.out.println("Connected...");
					System.out.println("accepted socket port:" + client.getPort());

					String line ="";
					while((line = in.readLine()) !=null){
						out.println("You said: " + line);
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
//		try (ServerSocket server = new ServerSocket(9000)) {
//			while(true){
//				Socket client = server.accept();
//				System.out.println("accepted socket port:" + client.getPort());
//				new WorkerThread(client).start();
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		}
	}

	private static class WorkerThread extends Thread {
		
		private Socket socket;
		
		public WorkerThread (Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			System.out.println("WorkerThread started port:" + socket.getPort());
			try ( BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter out =  new PrintWriter(socket.getOutputStream(),true);){
				
				System.out.println("Connected...");
				String line ="";
				while((line = in.readLine()) !=null){
					out.println("You said: " + line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					socket.close();
				} catch (IOException e) { }
			}
		}
	}
}
