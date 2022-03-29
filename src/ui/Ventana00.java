package ui;

import java.io.IOException;

import comm.Cliente;
import events.OnSearchPlayerlistenner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Ventana00 {
	
	private static Ventana00 instance;
	
	public  Ventana00() {
	}
	public static synchronized Ventana00 getInstance() {
		if(instance == null) {
			instance = new Ventana00();
		}
		return instance;
	}
	
	@FXML
    private AnchorPane anchorPaneInit;
	
	
	public SharedStage share;
	
	@FXML
    private AnchorPane paneinitial;
	Stage stage;
	Stage stageToShare;
	
	
	OnSearchPlayerlistenner searchListenner ;
	Cliente cliente ;
	

	 @FXML
	 void registrarJugador(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Ventana0.fxml"));
				Parent p;
				loader.setController(this);
				p = (Parent) loader.load();
				Scene scene = new Scene(p);
				
			    Stage stage = (Stage) paneinitial.getScene().getWindow();
				stage.setScene(scene);
				stageToShare = stage;
				stage.show();
				share = SharedStage.getInstance();
				share.setStage(stageToShare);
				System.out.println("Esta es mi stage"+ stageToShare);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cliente = Cliente.getInstance();
			cliente.setSearchingPLayer(this);
			searchListenner.startConection();
			
	 }


	public void setSearchListenner(OnSearchPlayerlistenner searchListenner) {
		this.searchListenner = searchListenner;
	}
	 
	
	
	 

	
	
		

	 
}