package p4_group_8_repo;

import javafx.scene.image.Image;

public class MediumLog extends Rideable {

	private double speed;
	
	//Constructor
	public MediumLog(int x, int y, double speed) {
		
		super(x, y, speed);
		this.speed = speed;
		setImage(new Image("file:src/main/resources/log2.png", 225, 225, true, true));
		
	}
	
	//Check if log is moving left
	public boolean getLeft() {
		return speed < 0;
	}
}
