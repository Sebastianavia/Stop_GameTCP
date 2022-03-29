package ui;

import javafx.stage.Stage;

public class SharedStage {
	
	
	Stage stage;

	private static SharedStage instance;
	
	private SharedStage() {
		// TODO Auto-generated constructor stub
	}
	public static synchronized SharedStage getInstance() {
		if(instance == null) {
			instance = new SharedStage();
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
