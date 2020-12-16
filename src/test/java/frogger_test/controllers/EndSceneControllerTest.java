package frogger_test.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import java.io.IOException;

import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

import frogger.controllers.EndSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EndSceneControllerTest extends ApplicationTest{

	private EndSceneController endSceneController;
	private FxRobot robot = new FxRobot();
	private Label endScore;
	
	@Override
	public void start(Stage stage) throws IOException {
		
		endSceneController = new EndSceneController();
		FXMLLoader endSceneLoader = new FXMLLoader(getClass().getResource("/views/EndScene.fxml"));
		endSceneLoader.setController(endSceneController);
		Pane endScene = endSceneLoader.load();
		
		stage.setScene(new Scene(endScene, 600, 800));
        stage.show();
		
        endSceneController.setEndScore(1234);
        
	}
	
	@Test
	public void endScoreIsVisible(){
		
		verifyThat("#endScore", isVisible());
		
	}
	
	@Test
	public void endScoreSetCorrectly(){
		
		endScore = (Label)find("#endScore");
		assertEquals(endScore.getText(), "1234");
		
	}
	
	@Test
	public void usernameTextFieldIsVisible(){
		
		verifyThat("#username", isVisible());
		
	}
		
	@Test 
	public void usernameNotMoreThan10Letters() {
		
		TextField username = (TextField)find("#username");
		robot.clickOn(username);
		robot.write("IIIIIIIIIIIIIIII");
		assertTrue(username.getText().length() <= 10);
		
	}
	
	@Test
	public void enterButtonIsVisible(){
		
		verifyThat("#enterButton", isVisible());
		
	}
	
	private <T extends Node> T find(final String query) {
		
		return (T) lookup(query).queryAll().iterator().next();
				
	}
	
}
