package p4_group_8_repo;

import javafx.scene.image.Image;

public class ShortTruck extends Obstacle {

	public ShortTruck(int x, int y, int speed) {
		
		super(x, y, speed);
		setShortTruckImage(speed);
		
	}
	
	private void setShortTruckImage(int speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/truck1Right.png", 120, 120, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/truck1Left.png", 120, 120, true, true));
		
		}
		
	}

}
