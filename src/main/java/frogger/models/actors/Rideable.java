package frogger.models.actors;

/**
 * <p>The abstract class Rideable defines common methods of all Rideable subclasses that can be ridden by {@link frogger.models.actors.Player} when intersected.</p>
 * <p>Rideable subclasses are added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a Rideable subclass in the level.</p>
 * <p>Rideable class cannot be initialized but a Rideable subclass can be initialized through concrete classes that inherits from it.</p>
 */
public abstract class Rideable extends Actor {

	/**
	 * <p>The speed that the Rideable will move at.</p>
	 * <p>Speed represents the displacement of Rideable per frame on the x-axis.</p>
	 */
	protected double speed;
	
	/**
	 * <p>The constructor of Rideable abstract class.</p>
	 * <p>Only used by Rideable subclasses as a super constructor as abstract Rideable class cannot be initialized.</p>
	 * @param x the initial position of Rideable on the x-axis.
	 * @param y the initial position of Rideable on the y-axis.
	 * @param speed the speed that the Rideable is will move at.
	 */
	public Rideable(int x, int y, double speed) {
		
		setX(x);
		setY(y);
		this.speed = speed;
		
	}
	
	/**
	 * <p>Method that keeps Rideable objects within game bounds.</p>
	 * @param speed the speed of Rideable objects.
	 */
	protected abstract void KeepWithinWindow(double speed);
	
	/**
     * <p>Method called by AnimationTimer in {@link frogger.models.levels.World#createTimer()} to cause Rideable objects to act every game frame.</p>
     * <p>Moves the Rideable objects based on speed every frame and ensures the Rideable objects will be in game bounds.</p>
     * @param now The timestamp of the current frame given in nanoseconds.
     */
	@Override
	public void act(long now) {
		
		move(speed , 0);
		KeepWithinWindow(speed);
		
	}
	
	/**
	 * <p>Get the speed of Rideable objects.</p>
	 * @return the double speed of Rideable objects.
	 */
	public double getSpeed() {
			
		return speed;
			
	}
	
}
