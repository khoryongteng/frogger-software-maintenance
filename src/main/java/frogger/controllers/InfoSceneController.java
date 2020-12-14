package frogger.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

public class InfoSceneController {

	private GameController gameController;
	
	public InfoSceneController() throws IOException {
		
		this.gameController = GameController.GameController();
		
	}
	
	@FXML
	private void exitInfo() {
		
		gameController.previousScene();
		
	}
	
}
