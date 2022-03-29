package comm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.google.gson.Gson;

import events.OnConectionListenner;
import ui.Main;



public class Cliente implements OnConectionListenner{

Main main = new Main(); 
private static Cliente instance;
	
	private Cliente() {
	}
	public static synchronized Cliente getInstance() {
		if(instance == null) {
			instance = new Cliente();
		}
		return instance;
	}
	
	
	private BufferedReader br;
	private BufferedWriter bw;
	
	public  void conectinCount() {
		
		Gson gson = new Gson();
		new Thread(()->{
			try {
				System.out.println("Aqui fue");
				Socket socket=new Socket("127.0.0.1",5555);
				System.out.println("Conectado");
				br = new 	BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				Scanner scanner=new Scanner(System.in); 
				String mesaggeString = br.readLine();
				
				String a = "A: Mensaje del ganador";
                String json = gson.toJson(a);
                bw.write(json+"\n");
                
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
		conectinCount();
		
	}
	
	public void setClient(Main main) {
		
		this.main = main;
		main.setConectionListenner(this);
		
	}

}

