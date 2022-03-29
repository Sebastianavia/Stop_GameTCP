package ui;

import server.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Ventana2 implements Initializable{
	Ventana1 ventana1Ventana1;
	
	@FXML
	private AnchorPane pane2;
	 
	//___________________________name_________________________
	
	@FXML
    private Label ownNameResult;

    @FXML
    private Label opponentNameResult;
    
    //__________________________Animal_________________________

    @FXML
    private Label ownAnimalResult;

    @FXML
    private Label opponentAnimalResult;
    
    //__________________________location_________________________

    @FXML
    private Label ownLocationResult;

    @FXML
    private Label opponentLocationResult;
    
    //____________________________object__________________________

    @FXML
    private Label ownObjectResult;

    @FXML
    private Label opponentObjectResult;

    //____________________________total________________________________//
    
    @FXML
    private Label total;
    
    @FXML
    private Label total1;
    
    //______________________________puntaje______________________________//
    @FXML
    private Label pun1; // yo

    @FXML
    private Label pun2; // yo

    @FXML
    private Label pun3; // yo

    @FXML
    private Label pun4; // yo

    @FXML
    private Label pun11; //enemy

    @FXML
    private Label pun21; //enemy

    @FXML
    private Label pun31; //enemy

    @FXML
    private Label pun41; //enemy
    //___________________________buttons________________________________//
    
    @FXML
    private Button finishBtn;
    
    

    
    
    
    public void recibe(Ventana1 ventana1,String nomYapelli,String animal, String ciuYpai, String cosa) {
    	ownNameResult.setText(nomYapelli);
    	ownAnimalResult.setText(animal);
    	ownLocationResult.setText(ciuYpai);
    	ownObjectResult.setText(cosa);
    	ventana1Ventana1=ventana1;
		

	}
    
    public void recibe2(Ventana1 ventana1, String pt1, String pt2,String pt3,String pt4,String totalpnt ) {
    	
    	pun1.setText(pt1);
    	pun2.setText(pt2);
    	pun3.setText(pt3);
    	pun4.setText(pt4);
    	total.setText(totalpnt);
    	
    }
	
    
    
    
    @FXML
    public void finishAction(ActionEvent event) {
    	Stage stage = (Stage) pane2.getScene().getWindow();
    	stage.close();
    }




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
