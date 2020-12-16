package frogger.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import frogger.models.HighScores;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

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
	
	public EndSceneController() throws IOException {
		
		this.gameController = GameController.GameController();
		
	}
	
	public void setHighScores(HighScores highScores) {
		
		this.highScores = highScores;
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		yourScore.setFont(Font.loadFont(fontUrl, 30));
		endScore.setFont(Font.loadFont(fontUrl, 50));
		nameText.setFont(Font.loadFont(fontUrl, 30));
		username.setFont(Font.loadFont(fontUrl, 22));
		
	}
	
	protected void setEndScore(int score) {
		
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
	private void enter() throws IOException {
		
		highScores.newScore(username.getText(), score);
		gameController.setHSList();
		gameController.nextScene();
		
			
	}
	
}