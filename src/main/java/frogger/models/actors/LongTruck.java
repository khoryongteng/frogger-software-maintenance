package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class LongTruck is an {@link frogger.models.actors.Obstacle} that kills the {@link frogger.models.actors.Player} when intersected.</p>
 * <p>LongTrucks are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a LongTruck in the level.</p>
 */
public class LongTruck extends Obstacle implements IObstacle{

	private Image longTruckRight = new Image("file:src/main/resources/images/truck2Right.png", 200, 200, true, true);
	private Image longTruckLeft = new Image("file:src/main/resources/images/truck2Left.png", 200, 200, true, true);
	
	/**
	 * <p>The constructor of LongTruck.</p>
	 * <p>The image of LongTruck based on the direction it is moving at implied by speed is set here.</p>
	 * @param x the initial position of LongTruck on the x-axis.
	 * @param y the initial position of LongTruck on the y-axis.
	 * @param speed the speed that the LongTruck will move at.
	 */
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

