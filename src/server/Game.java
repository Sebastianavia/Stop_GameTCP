package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.UUID;

import com.google.gson.Gson;

import javafx.application.Platform;




public class Game extends Thread {

	private Socket socket1;
	private Socket socket2;
	private String id;
	
	private BufferedReader reader1;
	private BufferedWriter writer1;
	private BufferedReader reader2;
	private BufferedWriter writer2;
	
	
	
	

	public Game(Socket socket1, Socket socket2) {
		this.socket1 = socket1;
		this.socket2 = socket2;
		id = UUID.randomUUID().toString();

	}

	@Override
	public void run() {
		Gson gson = new Gson();
		try {
			System.out.println("Se inicio sesion de juego");
			writer1 = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));
			reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
			writer2 = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
			reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
			String toSend = "";
			toSend = ramdonLetter();
			String tosendCliente= gson.toJson(toSend);
			
			
					writer1.write(tosendCliente + "\n");
					writer1.flush();
					
				
					writer2.write(tosendCliente + "\n");
					writer2.flush();
					
				
					
			
			
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String ramdonLetter() {
		String letras = new String("abcdefghijklmnñopqrstuvwxyz");
		
		Random numLetra = new Random();
		
		byte posLetra = (byte)numLetra.nextInt(letras.length()-1);
		
		System.out.print(letras.charAt(posLetra));
		
		char letterSende = letras.charAt(posLetra);
		
		String officialLe = "";
		officialLe = String.valueOf(letterSende);
		
		return officialLe;
	}
	
}