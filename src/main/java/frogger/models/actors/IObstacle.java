package frogger.models.actors;

/**
 * <p>The interface IObstacle is an interface for all concrete classes that are an {@link frogger.models.actors.Obstacle}.</p>
 */
public interface IObstacle {

	/**
	 * <p>This method needs to be provided by an implementation of IObstacle.</p>
	 * @param now The timestamp of the current frame given in nanoseconds.
	 */
	public void act(long now);
	
}
