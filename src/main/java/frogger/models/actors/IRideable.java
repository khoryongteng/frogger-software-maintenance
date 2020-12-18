package frogger.models.actors;

/**
 * <p>The interface IRideable is an interface for all concrete classes that are {@link frogger.models.actors.Rideable}.</p>
 */
public interface IRideable {

	/**
	 * <p>This method needs to be provided by an implementation of IRideable.</p>
	 * @param now The timestamp of the current frame given in nanoseconds.
	 */
	public void act(long now);
	
	/**
	 * <p>This method needs to be provided by an implementation of IRideable.</p>
	 * @return the double speed of IRideable object.
	 */
	public double getSpeed();
	
}
