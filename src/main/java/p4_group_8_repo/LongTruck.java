package p4_group_8_repo;

import javafx.scene.image.Image;

public class LongTruck extends Obstacle {

	public LongTruck(int x, int y, int speed) {
		
		super(x, y, speed);
		setLongTruckImage(speed);
		
	}
	
	private void setLongTruckImage(int speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/truck2Right.png", 200, 200, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/truck2Left.png", 200, 200, true, true));
		
		}
		
	}

}

