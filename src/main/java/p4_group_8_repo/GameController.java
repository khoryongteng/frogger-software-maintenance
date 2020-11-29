package p4_group_8_repo;

import java.io.IOException;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameController {

	private AnimationTimer timer;
	private SceneController sceneController;
	private Scene scene;
	private Level[] levels = new Level[2];
	private int currentScene;
	private int totalScore = 0;
	private int savedScore = 0;
	private MusicPlayer musicPlayer = new MusicPlayer();
	private StartSceneController startSceneController;
	private EndSceneController endSceneController;
	private HSSceneController hsSceneController;
	
	public GameController(Stage primaryStage, StartSceneController startSceneController, EndSceneController endSceneController, HSSceneController hsSceneController) throws IOException {
		
		this.startSceneController = startSceneController;
		FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
		startSceneLoader.setController(startSceneController);
		Pane startScene = startSceneLoader.load();
		
		this.endSceneController = endSceneController;
		FXMLLoader endSceneLoader = new FXMLLoader(getClass().getResource("/views/EndScene.fxml"));
		endSceneLoader.setController(endSceneController);
		Pane endScene = endSceneLoader.load();
		
		this.hsSceneController = hsSceneController;
		FXMLLoader hsSceneLoader = new FXMLLoader(getClass().getResource("/views/HighScoreScene.fxml"));
		hsSceneLoader.setController(hsSceneController);
		Pane hsScene = hsSceneLoader.load();
		
		scene  = new Scene(startScene, 600, 800);
		primaryStage.setScene(scene);
		
	    sceneController = new SceneController(this, scene);
	    sceneController.addScene(0, startScene);
	    currentScene = 0;
	    
	    levels[0] = new Level1();
		levels[1] = new Level2();
	    sceneController.addScene(1, levels[0]);
	    sceneController.addScene(2, levels[1]);
	    sceneController.addScene(3, endScene);
	    sceneController.addScene(4, hsScene);
	    
	    sceneController.activate(currentScene);
	    
	    primaryStage.setResizable(false);
	    primaryStage.show();
	    musicPlayer.play();
		
	}
	
	public void nextLevel() {
		
		sceneController.changeScene(++currentScene);
		if (scene.getRoot() instanceof Level) {
			
			((Level)scene.getRoot()).setScore(savedScore);;
			
		}
		else {
			
			stop();
			
		}
		
	}
	
	public void setHSList() {
		
		hsSceneController.setScoreText();
		
	}
	
	public void createTimer() {
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (scene.getRoot() instanceof Level) {
            		
            		if(((Level)scene.getRoot()).animal.changeScore()) {
            			
            			totalScore = savedScore + ((Level)scene.getRoot()).animal.getPoints();
            			((Level)scene.getRoot()).setScore(totalScore);
            			
            		}
            		
            		if(((Level)scene.getRoot()).animal.getStop()) {
            			
            			savedScore = totalScore;
            			nextLevel();
            			
            		}
            		
            	}
            	else {
            		
            		stop();
            		
            	}
            	
            }
        };
		
    }
	
	public void start() {
	
		currentScene = 1;
		sceneController.activate(currentScene);
    	createTimer();
        timer.start();
        
    }

    public void stop() {
    	
    	endSceneController.setEndScore(savedScore);
        timer.stop();
        
    }
    
}
