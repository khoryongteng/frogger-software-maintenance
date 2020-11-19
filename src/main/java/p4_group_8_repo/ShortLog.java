package p4_group_8_repo;

import javafx.scene.image.Image;

public class ShortLog extends Rideable {

	private double speed;
	
	//Constructor
	public ShortLog(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(new Image("file:src/main/resources/log3.png", 150, 150, true, true));
		
	}
	
	//Check if log is moving left
	public boolean getLeft() {
		return speed < 0;
	}
}
