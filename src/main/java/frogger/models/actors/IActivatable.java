package frogger.models.actors;

/**
 * <p>The interface IActivatable is an interface for all concrete classes that are activatable.</p>
 */
public interface IActivatable {

	/**
	 * <p>This method needs to be provided by an implementation of IActivatable.</p>
	 * @return the boolean whether the IActivatiable object is activated.
	 */
	public boolean isActivated();
	
	/**
	 * <p>This method needs to be provided by an implementation of IActivatable.</p>
	 */
	public void activate();
	
}
