package frogger.controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

import frogger.models.HighScores;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * 	<p>The class HSSceneController is the controller for the HighScoreScene FXML view.</p>
 * 	<p>Methods from this class are used to pass and display values in the view and to perform actions when view is interfaced by the user.</p>
 */
public class HSSceneController implements Initializable{
	
	private HighScores highScores;
	private GameController gameController;
	private String fontUrl = "file:src/main/resources/fonts/joystix monospace.ttf";
	
	@FXML 
	private Text highScore;
	
	@FXML
	private Text hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10;
	
	@FXML
	private Text score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
	
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	
	private Text[] hsText;
	private Text[] scoreText;
	private Text[] nameText;
	
	/**
	 * <p>The constructor of HSSceneController.</p>
	 * <p>Instance of {@link frogger.controllers.GameController} initialized through Singleton.</p>
	 */
	public HSSceneController() throws IOException {
		
		this.gameController = GameController.GameController();
		
	}
	
	/**
	 * <p>Set instance of {@link frogger.models.HighScores} that will be called by the HSSceneController.</p>
	 * @param highScores the instance of {@link frogger.models.HighScores}.
	 */
	public void setHighScores(HighScores highScores) {
		
		this.highScores = highScores;
		
	}
	
	/**
	 * <p>Method called automatically after FXML annotated fields are populated to initialize values to be displayed in HighScoreScene FXML View.</p>
	 * <p>Implemented from {@link javafx.fxml.Initializable} interface.</p>
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		hsText = new Text[] {hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10};
		
		scoreText = new Text[] {score1, score2, score3, score4, score5, score6, score7, score8, score9, score10};
		
		nameText = new Text[] {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
		
		highScore.setFont(Font.loadFont(fontUrl, 36));
		
		for(int i = 0;i<hsText.length;i++) {
			
			hsText[i].setFont(Font.loadFont(fontUrl, 22));
			
		}
		
		for(int i = 0;i<scoreText.length;i++) {
			
			scoreText[i].setFont(Font.loadFont(fontUrl, 22));
			
		}
		
		for(int i = 0;i<nameText.length;i++) {
			
			nameText[i].setFont(Font.loadFont(fontUrl, 22));
			
		}
		
	}

	/**
	 * <p>Set High Scores to be displayed in HighScoreScene FXML View.</p>
	 */
	protected void setScoreText() {
		
		String[] hsStringList = highScores.getScoreList();
		String[] parts;
		
		for(int i = 0; i < hsStringList.length;i++ ) {
			
			parts = hsStringList[i].split("\t");
			
			nameText[i].setText(parts[0]);
			scoreText[i].setText(parts[1]);
			
		}
		
	}
	
	@FXML
	private void retry() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		gameController.restart();
		
	}
	
}
