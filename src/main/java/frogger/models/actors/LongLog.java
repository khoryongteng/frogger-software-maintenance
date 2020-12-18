package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class LongLog is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>LongLogs are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a LongLog in the level.</p>
 */
public class LongLog extends Rideable implements IRideable{
	
	/**
	 * <p>The constructor of LongLog.</p>
	 * <p>The image of LongLog is set here.</p>
	 * @param x the initial position of LongLog on the x-axis.
	 * @param y the initial position of LongLog on the y-axis.
	 * @param speed the speed that the LongLog will move at.
	 */
	public LongLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/logs.png", 300, 300, true, true));
		
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
