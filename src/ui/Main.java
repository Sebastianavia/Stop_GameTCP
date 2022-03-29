package ui;




import java.io.IOException;
import events.*;
import comm.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	OnConectionListenner onconet;
	Cliente cliente = Cliente.getInstance();

	public static void main(String[] args) throws IOException {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("Ventana0.fxml"));
		Parent p = (Parent) loader.load();	
		Scene scene = new Scene(p);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		cliente.setClient(this);
		onconet.startConection();
	}

	public void setConectionListenner(OnConectionListenner onconect) {
		
		this.onconet = onconect;
		
		
	}


	

	/*@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("Ventana1.fxml"));
		Parent p = (Parent) loader.load();
		
		Scene scene = new Scene(p);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		
		
	}*/

	

}