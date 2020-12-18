package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class ShortTruck is an {@link frogger.models.actors.Obstacle} that kills the {@link frogger.models.actors.Player} when intersected.</p>
 * <p>ShortTruck are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a ShortTruck in the level.</p>
 */
public class ShortTruck extends Obstacle implements IObstacle{

	private Image shortTruckLeft = new Image("file:src/main/resources/images/truck1Left.png", 120, 120, true, true);
	private Image shortTruckRight = new Image("file:src/main/resources/images/truck1Right.png", 120, 120, true, true);
	
	/**
	 * <p>The constructor of ShortTruck.</p>
	 * <p>The image of ShortTruck based on the direction it is moving at implied by speed is set here.</p>
	 * @param x the initial position of ShortTruck on the x-axis.
	 * @param y the initial position of ShortTruck on the y-axis.
	 * @param speed the speed that the ShortTruck will move at.
	 */
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
