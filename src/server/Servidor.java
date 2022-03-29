package server;

import java.io.*;
import java.net.*;
import java.util.Random;



public class Servidor extends Thread{

	Socket servicio = null;
	DataInputStream flujoDatosEntrada = null;
	DataOutputStream flujoDatosSalida = null;

	public Servidor(Socket servicio,DataInputStream x,DataOutputStream y){  //Constructor

		this.servicio = servicio;
		System.out.println(servicio.getPort());

		
		
		
		flujoDatosEntrada = x;
		flujoDatosSalida = y;
	}

	public void run(){  //Esto es un metodo, que es lo que correra cada hilo de nustro servidor

		System.out.println("Se acepto una nueva conexion");
		letter() ;

		try{

			String mensaje = flujoDatosEntrada.readUTF();  //Recibimos un mensaje

			System.out.println(mensaje);  //Imprimimos el mensaje recibido
		}catch(Exception e){

		}

	}
	public void letter(){
		

		String letras = new String("abcdefghijklmnñopqrstuvwxyz");
		
		Random numLetra = new Random();
		
		byte posLetra = (byte)numLetra.nextInt(letras.length()-1);
		
		System.out.println(letras.charAt(posLetra));
	}


}