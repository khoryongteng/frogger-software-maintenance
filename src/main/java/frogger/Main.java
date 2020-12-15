package frogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import frogger.controllers.EndSceneController;
import frogger.controllers.GameController;
import frogger.controllers.HSSceneController;
import frogger.controllers.InfoSceneController;
import frogger.controllers.SceneController;
import frogger.controllers.StartSceneController;
import frogger.models.HighScores;
import frogger.models.levels.Level;
import frogger.models.levels.LevelFactory;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LevelFactory levelFactory = new LevelFactory();
		
		//Models
		HighScores highScores = new HighScores();
		ArrayList<Level> levels = levelFactory.getLevels();
		
		//Setup Scene Controllers
		StartSceneController startSceneController = new StartSceneController();
		InfoSceneController infoSceneController = new InfoSceneController();
		EndSceneController endSceneController = new EndSceneController(highScores);
		HSSceneController hsSceneController= new HSSceneController(highScores);

		//Setup Views
		FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
		startSceneLoader.setController(startSceneController);
		Pane startScene = startSceneLoader.load();
		
		FXMLLoader infoSceneLoader = new FXMLLoader(getClass().getResource("/views/InfoScene.fxml"));
		infoSceneLoader.setController(infoSceneController);
		Pane infoScene = infoSceneLoader.load();
		
		FXMLLoader endSceneLoader = new FXMLLoader(getClass().getResource("/views/EndScene.fxml"));
		endSceneLoader.setController(endSceneController);
		Pane endScene = endSceneLoader.load();
		
		FXMLLoader hsSceneLoader = new FXMLLoader(getClass().getResource("/views/HighScoreScene.fxml"));
		hsSceneLoader.setController(hsSceneController);
		Pane hsScene = hsSceneLoader.load();
		
		//Setup SceneController
		Scene scene  = new Scene(startScene, 600, 800);
		
		SceneController sceneController = new SceneController(scene);
		
		sceneController.addScene(0, startScene);
		sceneController.addScene(1, infoScene);
		sceneController.addScene(2, levels.get(0));
		sceneController.addScene(3, levels.get(1));
		sceneController.addScene(4, levels.get(2));
		sceneController.addScene(5, levels.get(3));
		sceneController.addScene(6, levels.get(4));
		sceneController.addScene(7, endScene);
		sceneController.addScene(8, hsScene);
		sceneController.activate(0);
		
		//Setup GameController
		GameController gameController = GameController.GameController();
		gameController.setSceneControllers(scene, sceneController, endSceneController, hsSceneController);
		
		primaryStage.setScene(scene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
	    
	    gameController.playMusic();
		
		
	}
	
	
}
