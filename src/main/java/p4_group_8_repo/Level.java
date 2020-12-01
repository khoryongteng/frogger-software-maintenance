package p4_group_8_repo;

import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public interface Level {
	
	public Animal getAnimal();
	
	public void setScore(int score);
	
	public void stop();
	
	public void start();
	
}
