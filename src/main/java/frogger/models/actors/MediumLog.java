package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class MediumLog is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>MediumLogs are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a MediumLog in the level.</p>
 */
public class MediumLog extends Rideable implements IRideable{
	
	/**
	 * <p>The constructor of MediumLog.</p>
	 * <p>The image of MediumLog is set here.</p>
	 * @param x the initial position of MediumLog on the x-axis.
	 * @param y the initial position of MediumLog on the y-axis.
	 * @param speed the speed that the MediumLog will move at.
	 */
	public MediumLog(int x, int y, double speed) {
		
		super(x, y, speed);
		setImage(new Image("file:src/main/resources/images/log2.png", 225, 225, true, true));
		
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
