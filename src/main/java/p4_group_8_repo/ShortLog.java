package p4_group_8_repo;

import javafx.scene.image.Image;

public class ShortLog extends Rideable {
	
	//Constructor
	public ShortLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/log3.png", 150, 150, true, true));
		
	}
	
}
