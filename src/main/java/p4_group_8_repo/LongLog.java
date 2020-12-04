package p4_group_8_repo;

import javafx.scene.image.Image;

public class LongLog extends Rideable {
	
	//Constructor
	public LongLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/logs.png", 300, 300, true, true));
		
	}
	
}
