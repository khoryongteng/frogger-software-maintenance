package frogger.models.actors;

/**
 * <p>The abstract class Obstacle defines common methods of all Obstacles subclasses that kills the {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Obstacle subclasses are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of an Obstacle in the level.</p>
 * <p>Obstacle class cannot be initialized but an Obstacle can be initialized through concrete classes that inherits from it.</p>
 */
public abstract class Obstacle extends Actor {
	
	/**
	 * <p>The speed that the Obstacle will move at.</p>
	 * <p>Speed represents the displacement of Obstacle per frame on the x-axis.</p>
	 */
	protected double speed;
	
	/**
	 * <p>The constructor of Obstacle abstract class.</p>
	 * <p>Only used by Obstacle subclasses as a super constructor as abstract Obstacle class cannot be initialized.</p>
	 * @param x the initial position of Obstacle on the x-axis.
	 * @param y the initial position of Obstacle on the y-axis.
	 * @param speed the speed that the Obstacle will move at.
	 */
	public Obstacle(int x, int y, double speed) {

		setX(x);
		setY(y);
		this.speed = speed;
		
	}

	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Obstacles to act every game frame.</p>
     * <p>Moves the Obstacle based on speed every frame and ensures the Obstacle will be in game bounds.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {
		move(speed , 0);
		KeepWithinWindow(speed);
	}
	
	private void KeepWithinWindow(double speed) {
		
		if (getX() > 600 && speed>0) {
			
			setX(-200);
			
		}
			
		if (getX() < -200 && speed<0) {
			
			setX(600);
			
		}
			
	}
	
}