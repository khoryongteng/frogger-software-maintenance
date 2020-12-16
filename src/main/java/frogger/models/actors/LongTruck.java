package frogger.models.actors;

import javafx.scene.image.Image;

public class LongTruck extends Obstacle implements IObstacle{

	private Image longTruckRight = new Image("file:src/main/resources/images/truck2Right.png", 200, 200, true, true);
	private Image longTruckLeft = new Image("file:src/main/resources/images/truck2Left.png", 200, 200, true, true);
	
	public LongTruck(int x, int y, double speed) {
		
		super(x, y, speed);
		setLongTruckImage(speed);
		
	}
	
	private void setLongTruckImage(double speed) {
		
		if(speed > 0) {
			
			setImage(longTruckRight);
			
		}
		else {
			
			setImage(longTruckLeft);
		
		}
		
	}

}

