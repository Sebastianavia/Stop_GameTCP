package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.google.gson.Gson;
import events.OnSearchPlayerlistenner;
import events.OnstartGameListenner;
import javafx.application.Platform;
import ui.Main;
import ui.Ventana00;
import ui.Ventana1;



public class Cliente implements OnSearchPlayerlistenner{
	
	Ventana1 ventana1;
	OnstartGameListenner onstart;
	
private static Cliente instance;
	
	public  Cliente() {
	}
	public static synchronized Cliente getInstance() {
		if(instance == null) {
			instance = new Cliente();
		}
		return instance;
	}

Main main = new Main(); 


Ventana00 venatan00=Ventana00.getInstance();
	
	
	private BufferedReader br;
	private BufferedWriter bw;
	
	public  void conectinCount() {
		
		Gson gson = new Gson();
		ventana1 = Ventana1.getInstance();
		ventana1.setStopGameListenner(this);
		
		
		new Thread(()->{
			try {
				System.out.println("Aqui fue");
				Socket socket=new Socket("127.0.0.1",5555);
				System.out.println("Conectado");
				br = new 	BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			

				String toSatar = "";
				toSatar = br.readLine() ;
				System.out.println(toSatar + "recibio el server");
				onstart.startStopGame(toSatar);
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}).start();
	}
	@Override
	public void startConection() {
		
		Platform.runLater(()->{
			
		conectinCount();
		
		});
		
		System.out.println("LLEgue hata aqui");
		
	}
	
	public void setClient(Main main) {
		
		this.main = main;
		//main.setConectionListenner(this);
		
	}
	public void setSearchingPLayer(Ventana00 ventana00) {
		
		this.venatan00=ventana00;
		ventana00.setSearchListenner(this);
		
	}
	public void setOnstart(OnstartGameListenner onstart) {
		this.onstart = onstart;
	}
	
	
	

}

