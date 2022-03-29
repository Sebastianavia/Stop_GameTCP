
package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;



public class Server {

	public static void main(String[] args) throws IOException {
		new Server();
	}

	private ArrayList<Game> sessions;

	public Server() throws IOException {
		sessions = new ArrayList<>();
		ServerSocket server = new ServerSocket(5555);
		while (true) {
			System.out.println("Esperando cliente...");
			Socket socket1 = server.accept();
			System.out.println("Nuevo cliente conectado!");
			System.out.println("Entró en el puerto: " + socket1.getPort());
			
			System.out.println("Esperando cliente...");
			Socket socket2 = server.accept();
			System.out.println("Nuevo cliente conectado!");
			System.out.println("Entró en el puerto: " + socket2.getPort());
			
			
			//new Thread(()->{
				
				Game session = new Game(socket1, socket2);
				
				session.start();
				sessions.add(session);
				
		//	}).start();
			
			
		}
	}
	
	

}












