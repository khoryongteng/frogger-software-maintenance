package frogger_test.controllers;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import java.io.IOException;

import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import frogger.controllers.EndSceneController;
import frogger.controllers.GameController;
import frogger.controllers.HSSceneController;
import frogger.controllers.InfoSceneController;
import frogger.controllers.SceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InfoSceneControllerTest extends ApplicationTest{

	private Scene scene;
	private FxRobot robot = new FxRobot();
	private Pane startTestPane = new Pane();
	
	@Override
	public void start(Stage stage) throws IOException {
		
		InfoSceneController infoSceneController = new InfoSceneController();
		FXMLLoader infoSceneLoader = new FXMLLoader(getClass().getResource("/views/InfoScene.fxml"));
		infoSceneLoader.setController(infoSceneController);
		Pane infoScene = infoSceneLoader.load();
		
		scene = new Scene(infoScene, 600, 800);
		
		GameController gameController = GameController.GameController();
		SceneController sceneController = new SceneController(scene);
		EndSceneController endSceneController = new EndSceneController();
		HSSceneController hsSceneController = new HSSceneController();
		gameController.setSceneControllers(scene, sceneController, endSceneController, hsSceneController);
		
		stage.setScene(scene);
        stage.show();
        
        sceneController.addScene(-1, startTestPane);
        sceneController.addScene(0, infoScene);
        
        
	}
	
	@Test
	public void quitButtonIsVisible(){
		
		verifyThat("#quitButton", isVisible());
		
	}
	
	@Test
	public void quitButtonClickDetected() {
		
		robot.clickOn((ImageView)find("#quitButton"));
		assertEquals(scene.getRoot(), startTestPane);
		
	}
	
	private <T extends Node> T find(final String query) {
		
		return (T) lookup(query).queryAll().iterator().next();
				
	}
	
}
