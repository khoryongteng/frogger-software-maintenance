package frogger.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

/**
 * 	<p>The class InfoSceneController is the controller for the InfoScene FXML view.</p>
 * 	<p>Methods from this class are used to perform actions when view is interfaced by the user.</p>
 */
public class InfoSceneController {

	private GameController gameController;
	
	/**
	 * <p>The constructor of InfoSceneController.</p>
	 * <p>Instance of {@link frogger.controllers.GameController} initialized through Singleton.</p>
	 */
	public InfoSceneController() throws IOException {
		
		this.gameController = GameController.GameController();
		
	}
	
	@FXML
	private void exitInfo() {
		
		gameController.previousScene();
		
	}
	
}
