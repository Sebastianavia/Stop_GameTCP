
package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class Server implements Session.OnMessageListener{

	public static void main(String[] args) throws IOException {
		new Server();
	}

	private ArrayList<Session> sessions;

	public Server() throws IOException {
		sessions = new ArrayList<>();
		ServerSocket server = new ServerSocket(5555);
		while (true) {
			System.out.println("Esperando cliente...");
			Socket socket = server.accept();
			System.out.println("Nuevo cliente conectado!");
			System.out.println("Entr� en el puerto: " + socket.getPort());
			Session session = new Session(socket);
			session.setListener(this);
			session.start();
			sessions.add(session);
		}
	}

	@Override
	public void onMessage(String line) {
		if(line.startsWith("ALL::")) {
			try {
				sendBroadCast(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sendBroadCast(String line) throws IOException {
		for(Session s : sessions) {
			s.sendMessage(line);
		}
	}

}












