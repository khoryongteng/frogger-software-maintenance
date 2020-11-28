package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

public class EndSceneController implements Initializable {
	
	private GameController gameController;
	private String fontUrl = "file:src/main/resources/fonts/joystix monospace.ttf";
	
	@FXML
	private Label endScore;
	
	@FXML 
	private Text yourScore;
	
	@FXML
	private Text nameText;
	
	@FXML 
	private TextField username;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		yourScore.setFont(Font.loadFont(fontUrl, 30));
		endScore.setFont(Font.loadFont(fontUrl, 50));
		nameText.setFont(Font.loadFont(fontUrl, 30));
		username.setFont(Font.loadFont(fontUrl, 22));
		
	}
	
	public void setGameController(GameController gameController) {
		
		this.gameController = gameController;
		
	}
	
	public void setEndScore(int score) {
		
		endScore.setText(Integer.toString(score));
		
	}
	
	@FXML
	private void enter() {
		
		System.out.println(username.getText().isEmpty());
		//gameController.nextLevel();
		
	}
	
}