package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage[] level = new MyStage[3];
    MusicPlayer musicPlayer = new MusicPlayer();
	Animal animal;
	SceneController sceneController;
	int currentLevel = 0;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		level[0] = new MyStage();
		level[1] = new MyStage();
		level[2] = new MyStage();
		
	    Scene scene  = new Scene(level[0],600,800);
	    
	    sceneController = new SceneController(scene, level.length);
	    sceneController.addScene(0, level[0]);
	    sceneController.addScene(1, level[1]);
	    sceneController.addScene(2, level[2]);
	    
	    sceneController.activate(0);
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
		
	}
	
	private void nextLevel() {

		sceneController.stopScene();
		sceneController.changeScene(++currentLevel);
		
	}
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	
            	if (currentLevel < (level.length - 1)) {
            		
            		if(level[currentLevel].animal.getStop()) {
            			
            			nextLevel();
            			
            		}
            		
            	}
            	else {
            		
            		if(level[currentLevel].animal.getStop()) {
            			
            			sceneController.stopScene();
            			stop();
                		
            		}
            		
            	}
            	/*
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		musicPlayer.stop();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            	*/
            }
        };
    }
	public void start() {
		musicPlayer.play();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    /*
    public void setNumber(int n) {
    	int shift = 0;
    	for(int i=0;i<3;i++) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		background.add(new Digit(k, 30, 360 - shift, 25));
    		shift+=30;
    	}
    }
    */
}
