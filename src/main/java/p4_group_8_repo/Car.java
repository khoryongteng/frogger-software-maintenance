package p4_group_8_repo;

import javafx.scene.image.Image;

public class Car extends Obstacle {

	public Car(int x, int y, int speed) {
		
		super(x, y, speed);
		setCarImage(speed);
		
	}
	
	private void setCarImage(int speed) {
		
		if(speed > 0) {
			
			setImage(new Image("file:src/main/resources/car1Right.png", 50, 50, true, true));
			
		}
		else if (speed < 0) {
			
			setImage(new Image("file:src/main/resources/car1Left.png", 50, 50, true, true));
		
		}
		
	}

}
