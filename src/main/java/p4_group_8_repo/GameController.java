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
	private int currentScene;
	private int totalScore = 0;
	private int savedScore = 0;
	private MusicPlayer musicPlayer = new MusicPlayer();
	private SceneController sceneController;
	private EndSceneController endSceneController;
	private HSSceneController hsSceneController;
	private Scene scene;
	
	public GameController(Scene scene, SceneController sceneController, EndSceneController endSceneController, HSSceneController hsSceneController) throws IOException {
		
		this.scene = scene;
		this.sceneController = sceneController;
		this.endSceneController = endSceneController;
		this.hsSceneController = hsSceneController;
		currentScene = 0;
		
	}
	
	public void playMusic() {
    	
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
	
	private void createTimer() {
		
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

    private void stop() {
    	
    	endSceneController.setEndScore(savedScore);
        timer.stop();
        
    }
    
    public void restart() {
    	
    	savedScore = 0;
    	totalScore = 0;
    	sceneController.resetScenes();
    	start();
    	
    }
    
}
