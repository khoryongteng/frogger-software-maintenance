package frogger.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import frogger.models.MusicPlayer;
import frogger.models.levels.Level;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

/**
 *	<p>The class GameController manages the core flow of the Frogger game.</p>
 * 	<p>Methods in GameController called to pass values, save values, call methods as a mediator between {@link frogger.controllers.SceneController}, {@link frogger.controllers.StartSceneController}, {@link frogger.controllers.InfoSceneController}, {@link frogger.controllers.EndSceneController}, {@link frogger.controllers.HSSceneController}.</p>	
 * 	<p>GameController used to detect {@link frogger.models.levels.Level} child class completions to facilitate automatic level swap through calling {@link frogger.controllers.SceneController#changeScene(Integer)}.</p>
 * 	<p>Core controller for Frogger game MVC design pattern and Mediator between {@link frogger.controllers.SceneController}, {@link frogger.controllers.StartSceneController}, {@link frogger.controllers.InfoSceneController}, {@link frogger.controllers.EndSceneController}, {@link frogger.controllers.HSSceneController} in Mediator design pattern.</p>
 * 	<p>Initialized as a Singleton to avoid multiple instances as it may cause errors.</p>
 */

public class GameController {

	private static GameController gameController_instance = null;
	
	private AnimationTimer timer;
	private int currentScene;
	private int totalScore = 0;
	private int savedScore = 0;
	private MusicPlayer musicPlayer = new MusicPlayer();
	private SceneController sceneController;
	private EndSceneController endSceneController;
	private HSSceneController hsSceneController;
	private Scene scene;
	
	private GameController() {
		
		currentScene = 0;
		
	}
	
	
	/**
	 *	<p>The Singleton constructor method of GameController. </p>
	 *	<p>Get GameController instance using GameController.GameController()</p>
	 */
	public static GameController GameController() throws IOException {
		
		if (gameController_instance == null) {
			
			gameController_instance = new GameController();
			
		}
		
		return gameController_instance;
		
	}
	
	
	/**
	 *	<p>Set the Scene, SceneController objects that will be called and used by GameController.</p>
	 *	@param scene the instance of Scene used for display.
	 *	@param sceneController the instance of {@link frogger.controllers.SceneController} to be called when switching scenes.
	 *	@param endSceneController the instance of {@link frogger.controllers.EndSceneController} to be called to generate EndScene when all {@link frogger.models.levels.Level} are completed.
	 *	@param hsSceneController the instance of {@link frogger.controllers.HSSceneController} to be called to generate HighScoreScene.
	 */
	public void setSceneControllers(Scene scene, SceneController sceneController, EndSceneController endSceneController, HSSceneController hsSceneController) {
		
		this.scene = scene;
		this.sceneController = sceneController;
		this.endSceneController = endSceneController;
		this.hsSceneController = hsSceneController;
		
	}
	
	/**
	 * 	<p>Plays music in Scene using {@link frogger.models.MusicPlayer}.</p>
	 */
	public void playMusic() {
    	
    	musicPlayer.play();
    	
    }
	
	private void nextLevel() {
		
		nextScene();
		
		if (scene.getRoot() instanceof Level) {
			
			((Level)scene.getRoot()).setScore(savedScore);
			
		}
		else {
			
			stop();
			
		}
		
	}
	
	/**
	 * <p>Switches scene to next scene saved in {@link frogger.controllers.SceneController} and keeps track of which scene is currently being displayed.</p>
	 */
	protected void nextScene() {
		
		sceneController.changeScene(++currentScene);
		
	}
	
	/**
	 * <p>Switches scene to previous scene saved in {@link frogger.controllers.SceneController} and keeps track of which scene is currently being displayed.</p>
	 */
	protected void previousScene() {
		
		sceneController.changeScene(--currentScene);
		
	}
	
	/**
	 *	<p>Sets high Scores to be displayed in HighScoreScene using {@link frogger.controllers.HSSceneController}.</p>
	 */
	protected void setHSList() {
		
		hsSceneController.setScoreText();
		
	}
	
	private void createTimer() {
		
		timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (scene.getRoot() instanceof Level) {
            		
            		if(((Level)scene.getRoot()).changeScore()) {
            			
            			totalScore = savedScore + ((Level)scene.getRoot()).getPoints();
            			((Level)scene.getRoot()).setScore(totalScore);
            			
            		}
            		
            		if(((Level)scene.getRoot()).getStop()) {
            			
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
	
	/**
	 * <p>Starts the game on first {@link frogger.models.levels.Level} saved in {@link frogger.controllers.SceneController}.</p>
	 */
	protected void start() {
	
		currentScene = sceneController.getFirstLevel();
		
		if (currentScene == -1) {
			
			System.out.println("No Levels were set!");
			currentScene = 0;
			
		}
		else {
			
			sceneController.activate(currentScene);
	    	createTimer();
	        timer.start();
			
		}

    }

    private void stop() {
    	
    	endSceneController.setEndScore(savedScore);
        timer.stop();
        
    }
    
    /**
     * <p>Restarts the game by reseting game score and {@link frogger.models.levels.Level} saved in {@link frogger.controllers.SceneController}.</p>
     */
    protected void restart() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	savedScore = 0;
    	totalScore = 0;
    	sceneController.resetScenes();
    	start();
    	
    }
    
}
