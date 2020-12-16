package frogger_test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import frogger.controllers.SceneController;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneControllerTest extends ApplicationTest{

	private Pane pane0 = new Pane();
	private Pane pane1 = new Pane();
	private Pane pane2 = new Pane();
	
	private SceneController sceneController;
	private Scene scene;
	
	@Override
	public void start(Stage stage) {
		
		scene = new Scene(pane0);
		sceneController = new SceneController(scene);
		
		sceneController.addScene(0, pane0);
		sceneController.addScene(1, pane1);
		sceneController.addScene(2, pane2);
		
		stage.setScene(scene);
		stage.show();
	}
	
	@Test
	public void activateChangesScenes() {
		
		sceneController.activate(2);
		assertEquals(scene.getRoot(), pane2);
		
	}
	
	@Test
	public void canAddScenes() {
		
		Pane pane3 = new Pane();
		sceneController.addScene(3, pane3);
		sceneController.activate(3);
		assertEquals(scene.getRoot(), pane3);
		
	}
	
}
