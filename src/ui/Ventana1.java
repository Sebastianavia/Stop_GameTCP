package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Ventana1 implements Initializable{
	
	Ventana1 ventana1;
	
	
	public static String nomYapelli = "";
	public static String animal = "";
	public static String ciuYpai = "";
	public static String cosa  ="";
	
	public static int p1 = 0;
	public static int p2 = 0;
	public static int p3 = 0;
	public static int p4 = 0;
	public static int totalp = 0;
	
	public static String pt1= "";
	public static String pt2= "";
	public static String pt3= "";
	public static String pt4= "";
	public static String totalpnt = "";
	
	@FXML
    private AnchorPane pane;
	@FXML
    private Label title;

    @FXML
    private Button stopBtn;

    @FXML
    private TextField nameAnswer;

    @FXML
    private TextField animalAnswer;

    @FXML
    private TextField locationAnswer;

    @FXML
    private TextField objectAnswer;

    @FXML
    void passVent(ActionEvent event) throws IOException{

    	nomYapelli = nameAnswer.getText();
    	animal = animalAnswer.getText();
		ciuYpai= locationAnswer.getText();
		cosa = objectAnswer.getText();
		
		if(nomYapelli == null) {
			p1 = 0;
			 pt1 = p1 + "";
			
		} else {
			p1 = 100;
			 pt1 = p1 + "";
		}
		
		if(animal == null) {
			p2 = 0;		
			 pt2 = p2 + "";
		} else {
			p2 = 100;
			 pt2 = p2 + "";
		}
		if(ciuYpai == null) {
			p3 = 0;	
			 pt3 = p3 + "";
		} else {
			p3 = 100;
			 pt3 = p3 + "";
		}
		if(cosa == null) {
			p4 = 0;	
			 pt4 = p4 + "";
		} else {
			p4 = 100;
			 pt4 = p4 + "";
		}
		
		totalp = p1 + p2 + p3+ p4;
		totalpnt = totalp+""; 
		

		if(!nomYapelli.isEmpty() & !animal.isEmpty() & !ciuYpai.isEmpty() & !cosa.isEmpty()){
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("Ventana2.fxml"));
		Parent p = (Parent) loader.load();
		
		
		Ventana2 ventana2Instance = (Ventana2)loader.getController();
		ventana2Instance.recibe(ventana1, nomYapelli,animal,ciuYpai,cosa);
		ventana2Instance.recibe2(ventana1, pt1,pt2,pt3,pt4,totalpnt);
		
		Scene scene = new Scene(p);
		Stage stage = (Stage) pane.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    
    	}
		
	

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ventana1 = this;
		
	}

}
