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
		
		//Setup temporary Scene
		Scene scene  = new Scene(new Pane(), 600, 800);
		
		//Models
		HighScores highScores = new HighScores();
		ArrayList<Level> levels = levelFactory.getLevels();
		
		//Setup Scene Controllers
		StartSceneController startSceneController = new StartSceneController();
		InfoSceneController infoSceneController = new InfoSceneController();
		EndSceneController endSceneController = new EndSceneController(highScores);
		HSSceneController hsSceneController= new HSSceneController(highScores);
		SceneController sceneController = new SceneController(scene);
		GameController gameController = GameController.GameController();
		
		//Link Scene Controllers to GameController
		gameController.setSceneControllers(scene, sceneController, endSceneController, hsSceneController);
		
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
		
		//Add Scenes into SceneController
		sceneController.addScene(0, startScene);
		sceneController.addScene(1, infoScene);
		
		int j = 2;
		for (int i = 0; i < levels.size(); i++) {
			
			sceneController.addScene(j, levels.get(i));
			j++;
			
		}
		
		sceneController.addScene(j, endScene);
		sceneController.addScene(j + 1, hsScene);
		
		//Set Starting Scene
		sceneController.activate(0);
		
		//Stage Setup
		primaryStage.setScene(scene);
	    primaryStage.setResizable(false);
	    primaryStage.show();
	    gameController.playMusic();
		
		
	}
	
	
}
