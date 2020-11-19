package p4_group_8_repo;

import javafx.scene.image.Image;

public class LongLog extends Rideable {
	
	private double speed;
	
	//Constructor
	public LongLog(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(new Image("file:src/main/resources/logs.png", 300, 300, true, true));
		
	}
	
	//Check if log is moving left
	public boolean getLeft() {
		return speed < 0;
	}
	
}
