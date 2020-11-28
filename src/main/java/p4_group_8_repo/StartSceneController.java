package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartSceneController {

	private GameController gameController;
	
	public void setGameController(GameController gameController) {
		
		this.gameController = gameController;
		
	}
	
	@FXML
	private void startGame() {
		
		gameController.start();
		
	}
	
}
