package frogger.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

public class StartSceneController {

	private GameController gameController;
	
	public StartSceneController() throws IOException {
		
		 this.gameController= GameController.GameController();
		
	}
	
	@FXML
	private void startGame() {
		
		gameController.start();
		
	}
	
	@FXML
	private void openInfo() {
		
		gameController.nextScene();
		
	}
	
}
