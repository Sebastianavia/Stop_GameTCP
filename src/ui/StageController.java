package ui;

import javafx.stage.Stage;

public class StageController {
	
	
	 private static StageController instance;
	private Stage stage;

	    private StageController() {	        
	    }
	    public static synchronized StageController getInstance() {
	        if(instance == null) {
	            instance = new StageController();
	        }
	        return instance;
	    }

	    public Stage getStage() {
	        return stage;
	    }
	    public void setStage(Stage stage) {
	        this.stage = stage;
	    }
	
	

}
