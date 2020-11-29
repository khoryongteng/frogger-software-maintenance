package p4_group_8_repo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HSSceneController implements Initializable{
	
	private HighScores highScores;
	private String fontUrl = "file:src/main/resources/fonts/joystix monospace.ttf";
	
	@FXML 
	private Text highScore;
	
	@FXML
	private Text hs1, hs2, hs3, hs4, hs5, hs6, hs7, hs8, hs9, hs10;
	
	@FXML
	private Text score1, score2, score3, score4, score5, score6, score7, score8, score9, score10;
	
	@FXML
	private Text name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
	
	@FXML 
	private Button retryButton;
	
	private Text[] hsText;
	private Text[] scoreText;
	private Text[] nameText;
	
	public HSSceneController(HighScores highScores) {
		
		this.highScores = highScores;
		
	}
	
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

	public void setScoreText() {
		
		String[] hsStringList = highScores.getScoreList();
		String[] parts;
		
		for(int i = 0; i < hsStringList.length;i++ ) {
			
			parts = hsStringList[i].split("\t");
			
			nameText[i].setText(parts[0]);
			scoreText[i].setText(parts[1]);
			
		}
		
	}
	
}
