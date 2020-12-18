package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class Crocodile is a {@link frogger.models.actors.Rideable} that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Crocodiles are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Crocodile in the level.</p>
 */
public class Crocodile extends Rideable implements IRideable{

	private Image crocodileRight = new Image("file:src/main/resources/images/crocodileRight.png", 160, 160, true, true);
	private Image crocodileLeft = new Image("file:src/main/resources/images/crocodileLeft.png", 160, 160, true, true);
	
	/**
	 * <p>The constructor of Crocodile.</p>
	 * <p>The image of Crocodile based on the direction it is moving at implied by speed is set here.</p>
	 * @param x the initial position of Crocodile on the x-axis.
	 * @param y the initial position of Crocodile on the y-axis.
	 * @param speed the initial speed that the Crocodile will move at.
	 */
	public Crocodile(int x, int y, double speed) {
		
		super(x, y, speed);
		setCrocodileImage(speed);
		
	}

	@Override
	protected void KeepWithinWindow(double speed) {
	
	}
	
	private void movement(double speed) {
		
		if((speed > 0)&&(getX() > 450)){
			
			this.speed = -speed;
			
		}
		else if((speed < 0)&&(getX() < 0)) {
			
			this.speed = -speed;
			
		}
		
	}
	
	private void setCrocodileImage(double speed) {
		
		if(speed > 0) {
			
			setImage(crocodileRight);
			
		}
		else {
			
			setImage(crocodileLeft);
		
		}
		
	}
	
	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Crocodile to act every game frame.</p>
     * <p>Moves the Crocodile objects based on speed every frame, and when Crocodile reaches edge of the game, change moving direction by changing the speed.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {
		
		move(speed , 0);
		movement(speed);
		setCrocodileImage(speed);
		
	}
	
}
