package frogger.controllers;

import javafx.fxml.FXML;

public class StartSceneController {

	private GameController gameController;
	
	public void setGameController(GameController gameController) {
		
		this.gameController = gameController;
		
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
