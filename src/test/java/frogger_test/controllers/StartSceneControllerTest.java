package frogger_test.controllers;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.api.FxRobot;

import frogger.controllers.EndSceneController;
import frogger.controllers.GameController;
import frogger.controllers.HSSceneController;
import frogger.controllers.SceneController;
import frogger.controllers.StartSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartSceneControllerTest extends ApplicationTest{

		private Scene scene;
		private FxRobot robot = new FxRobot();
		private Pane infoTestPane = new Pane();
		private Pane gameTestPane = new Pane();
	
	public void start(Stage stage) throws IOException {
		
		StartSceneController startSceneController = new StartSceneController();
		FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
		startSceneLoader.setController(startSceneController);
		Pane startScene = startSceneLoader.load();
		
		scene = new Scene(startScene, 600, 800);
		
		GameController gameController = GameController.GameController();
		SceneController sceneController = new SceneController(scene);
		EndSceneController endSceneController = new EndSceneController();
		HSSceneController hsSceneController = new HSSceneController();
		gameController.setSceneControllers(scene, sceneController, endSceneController, hsSceneController);
		
		stage.setScene(scene);
        stage.show();
        
        sceneController.addScene(2, gameTestPane);
        sceneController.addScene(1, infoTestPane);
        
	}
	
	@Test
	public void startButtonIsVisible(){
		
		verifyThat("#startButton", isVisible());
		
	}
	
	@Test
	public void infoButtonIsVisible() {
		
		verifyThat("#infoButton", isVisible());
		
	}
	
	@Test
	public void startButtonClickDetected() {
		
		robot.clickOn((Button)find("#startButton"));
		assertEquals(scene.getRoot(), gameTestPane);
		
	}
	
	@Test
	public void infoButtonClickDetected() {
		
		robot.clickOn((Button)find("#infoButton"));
		assertEquals(scene.getRoot(), infoTestPane);
		
	}
	
	private <T extends Node> T find(final String query) {
		
		return (T) lookup(query).queryAll().iterator().next();
				
	}
	
}
