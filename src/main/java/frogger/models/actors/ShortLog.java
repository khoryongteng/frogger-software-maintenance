package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class ShortLog is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>ShortLogs are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a ShortLog in the level.</p>
 */
public class ShortLog extends Rideable implements IRideable{
	
	/**
	 * <p>The constructor of ShortLog.</p>
	 * <p>The image of ShortLog is set here.</p>
	 * @param x the initial position of ShortLog on the x-axis.
	 * @param y the initial position of ShortLog on the y-axis.
	 * @param speed the speed that the ShortLog will move at.
	 */
	public ShortLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/log3.png", 150, 150, true, true));
		
	}
	
	@Override
	protected void KeepWithinWindow(double speed) {
		
		if (getX()>600 && speed>0) {
			
			setX(-300);
			
		}
	
		if (getX()<-300 && speed<0) {
			
			setX(700);
			
		}
				
	}
	
}
