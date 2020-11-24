package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class GameController {

	AnimationTimer timer;
	private GameView gameView;
	private SceneController sceneController;
	private World[] levels = new World[2];
	private int currentLevel;
	private int totalScore = 0;
	private int savedScore = 0;
	
	public GameController(GameView gameView) {
		
		this.gameView = gameView;
		
		levels[0] = new Level1();
		levels[1] = new Level2();
		
		Scene scene  = new Scene(levels[0],600,800);
	    gameView.setScene(scene);
		
	    sceneController = new SceneController(scene, levels.length, gameView);
	    sceneController.addScene(0, levels[0]);
	    sceneController.addScene(1, levels[1]);
	    sceneController.activate(0);
	    
	    gameView.start();
		start();
		
	}
	
	private void nextLevel() {

		sceneController.changeScene(++currentLevel);
		((Level)levels[currentLevel]).setScore(totalScore);
		
	}
	
	public void keyHandler(KeyEvent event) {
		
		((Level)levels[currentLevel]).controlsHandler(event);
		
	}
	
	public void createTimer() {
		
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (((Level)levels[currentLevel]).animal.changeScore()) {
            		
            		totalScore = savedScore + ((Level)levels[currentLevel]).animal.getPoints();
            		((Level)levels[currentLevel]).setScore(totalScore);
            		
            	}
            	
            	
            	if (currentLevel < (levels.length - 1)) {
            		
            		if(((Level)levels[currentLevel]).animal.getStop()) {
            			
            			savedScore = totalScore;
            			nextLevel();
            			
            		}
            		
            	}
            	else {
            		
            		if(((Level)levels[currentLevel]).animal.getStop()) {
            			
            			savedScore = totalScore;
            			sceneController.stopScene();
            			stop();
                		
            		}
            		
            	}
            	
            }
        };
    }
	
	public void start() {
		
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
}
