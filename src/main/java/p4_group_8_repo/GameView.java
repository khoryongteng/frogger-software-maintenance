package p4_group_8_repo;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class GameView {

	private Stage primaryStage;
	private MusicPlayer musicPlayer = new MusicPlayer();
	private GameController gameController;
	
	public GameView(Stage primaryStage){
		
		this.primaryStage = primaryStage;
		
	}
	
	public void setController(GameController gameController) {
		
		this.gameController = gameController;
		
	}
	
	public void setScene(Scene scene) {
		
		primaryStage.setScene(scene);
		
	}
	
	public void setKeyListener(Scene scene) {
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			
			public void handle(KeyEvent event){
				
				gameController.keyHandler(event);
				
			}
			
		});
		
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				
				gameController.keyHandler(event);
				
			}
			
		});
		
	}
	
	public void start(){
		
		primaryStage.show();
		musicPlayer.play();
		
	}
	
	public void stop() {
		
		musicPlayer.stop();
		
	}
	
}
