package frogger_test.controllers;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

import java.io.IOException;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import frogger.controllers.HSSceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HSSceneControllerTest extends ApplicationTest{

	@Override
	public void start(Stage stage) throws IOException {
		
		HSSceneController hsSceneController = new HSSceneController();
		FXMLLoader hsSceneLoader = new FXMLLoader(getClass().getResource("/views/HighScoreScene.fxml"));
		hsSceneLoader.setController(hsSceneController);
		Pane hsScene = hsSceneLoader.load();
		
		stage.setScene(new Scene(hsScene, 600, 800));
        stage.show();
        
	}
	
	@Test
	public void retryButtonIsVisible(){
		
		verifyThat("#retryButton", isVisible());
		
	}
	
	private <T extends Node> T find(final String query) {
		
		return (T) lookup(query).queryAll().iterator().next();
				
	}
	
	
}
