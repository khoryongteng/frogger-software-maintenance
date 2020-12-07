package frogger.models.actors;

import javafx.scene.image.Image;

public class Car extends Obstacle {

	private Image carLeft = new Image("file:src/main/resources/images/car1Left.png", 50, 50, true, true);
	private Image carRight = new Image("file:src/main/resources/images/car1Right.png", 50, 50, true, true);
	
	public Car(int x, int y, double speed) {
		
		super(x, y, speed);
		setCarImage(speed);
		
	}
	
	private void setCarImage(double speed) {
		
		if(speed > 0) {
			
			setImage(carRight);
			
		}
		else {
			
			setImage(carLeft);
		
		}
		
	}

}
