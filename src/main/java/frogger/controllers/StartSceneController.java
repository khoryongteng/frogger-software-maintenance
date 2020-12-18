package frogger.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

/**
 * 	<p>The class StartSceneController is the controller for the StartScene FXML view.</p>
 * 	<p>Methods from this class are used to perform actions when view is interfaced by the user.</p>
 */
public class StartSceneController {

	private GameController gameController;
	
	/**
	 * <p>The constructor of StartSceneController.</p>
	 * <p>Instance of {@link frogger.controllers.GameController} initialized through Singleton.</p>
	 */
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
