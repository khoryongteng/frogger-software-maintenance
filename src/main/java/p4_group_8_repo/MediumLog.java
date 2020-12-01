package p4_group_8_repo;

import javafx.scene.image.Image;

public class MediumLog extends Rideable {
	
	//Constructor
	public MediumLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/log2.png", 225, 225, true, true));
		
	}
	
}
