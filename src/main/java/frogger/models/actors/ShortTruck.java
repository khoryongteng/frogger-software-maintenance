package frogger.models.actors;

import javafx.scene.image.Image;

public class ShortTruck extends Obstacle implements IObstacle{

	private Image shortTruckLeft = new Image("file:src/main/resources/images/truck1Left.png", 120, 120, true, true);
	private Image shortTruckRight = new Image("file:src/main/resources/images/truck1Right.png", 120, 120, true, true);
	
	public ShortTruck(int x, int y, double speed) {
		
		super(x, y, speed);
		setShortTruckImage(speed);
		
	}
	
	private void setShortTruckImage(double speed) {
		
		if(speed > 0) {
			
			setImage(shortTruckRight);
			
		}
		else {
			
			setImage(shortTruckLeft);
		
		}
		
	}

}
