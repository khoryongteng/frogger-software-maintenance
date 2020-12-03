package p4_group_8_repo;

import javafx.fxml.FXML;

public class InfoSceneController {

	private GameController gameController;
	
	public void setGameController(GameController gameController) {
		
		this.gameController = gameController;
		
	}
	
	@FXML
	private void exitInfo() {
		
		gameController.previousScene();
		
	}
	
}
