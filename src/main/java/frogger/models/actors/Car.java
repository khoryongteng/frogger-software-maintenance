package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class Car is an {@link frogger.models.actors.Obstacle} that kills the {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Cars are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Car in the level.</p>
 */
public class Car extends Obstacle implements IObstacle{

	private Image carLeft = new Image("file:src/main/resources/images/car1Left.png", 50, 50, true, true);
	private Image carRight = new Image("file:src/main/resources/images/car1Right.png", 50, 50, true, true);
	
	/**
	 * <p>The constructor of Car.</p>
	 * <p>The image of Car based on the direction it is moving at implied by speed is set here.</p>
	 * @param x the initial position of Car on the x-axis.
	 * @param y the initial position of Car on the y-axis.
	 * @param speed the speed that the Car will move at.
	 */
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
