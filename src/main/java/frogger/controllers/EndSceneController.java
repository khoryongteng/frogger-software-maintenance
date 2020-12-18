package frogger.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import frogger.models.HighScores;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

/**
 * 	<p>The class EndSceneController is the controller for the EndScene FXML view.</p>
 * 	<p>Methods from this class are used to pass and display values in the view and to perform actions when view is interfaced by the user.</p>
 */
public class EndSceneController implements Initializable {
	
	private GameController gameController;
	private HighScores highScores;
	private String fontUrl = "file:src/main/resources/fonts/joystix monospace.ttf";
	private int score;
	
	@FXML
	private Label endScore;
	
	@FXML 
	private Text yourScore, nameText;
	
	@FXML 
	private TextField username;
	
	/**
	 * <p>The constructor of EndSceneController.</p>
	 * <p>Instance of {@link frogger.controllers.GameController} initialized through Singleton.</p>
	 */
	public EndSceneController() throws IOException {
		
		this.gameController = GameController.GameController();
		
	}
	
	/**
	 * <p>Set instance of {@link frogger.models.HighScores} that will be called by the EndSceneController.</p>
	 * @param highScores the instance of {@link frogger.models.HighScores}.
	 */
	public void setHighScores(HighScores highScores) {
		
		this.highScores = highScores;
		
	}
	
	/**
	 * <p>Method called automatically after FXML annotated fields are populated to initialize values to be displayed in EndScene FXML View.</p>
	 * <p>Implemented from {@link javafx.fxml.Initializable} interface.</p>
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		yourScore.setFont(Font.loadFont(fontUrl, 30));
		endScore.setFont(Font.loadFont(fontUrl, 50));
		nameText.setFont(Font.loadFont(fontUrl, 30));
		username.setFont(Font.loadFont(fontUrl, 22));
		
	}
	
	/**
	 * <p>Set score to be displayed in #endScore in EndScene FXML View.</p>
	 * @param score the score to be displayed in int up to 4 digits.
	 */
	public void setEndScore(int score) {
		
		this.score = score;
		endScore.setText(Integer.toString(score));
		
	}
	
	@FXML
	private void keyTyped() {
		
		if(username.getText().length() > 10) {
			
			username.setText(username.getText().substring(0, 10));
			username.positionCaret(10);
			
		}
		
	}
	
	@FXML
	private void enter() throws IOException, URISyntaxException {
		
		highScores.newScore(username.getText(), score);
		gameController.setHSList();
		gameController.nextScene();
		
			
	}
	
}