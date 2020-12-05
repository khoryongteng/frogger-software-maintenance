package frogger.models.actors;

import javafx.scene.image.Image;

public class LongTruck extends Obstacle {

	public LongTruck(int x, int y, double speed) {
		
		super(x, y, speed);
		setLongTruckImage(speed);
		
	}
	
	private void setLongTruckImage(double speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/images/truck2Right.png", 200, 200, true, true));
			
		}
		else {
			
			setImage(new Image("file:src/main/resources/images/truck2Left.png", 200, 200, true, true));
		
		}
		
	}

}

