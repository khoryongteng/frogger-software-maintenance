package frogger.models.actors;

/**
 * <p>The interface ISinkable is an interface for all concrete classes that are Sinkable.</p>
 */
public interface ISinkable extends IRideable{

	/**
	 * <p>This method needs to be provided by an implementation of ISinkable.</p>
	 * @return the boolean whether the ISinkable object is sunk and cannot be ridden by {@link frogger.models.actors.Player}.
	 */
	public boolean isSunk();
	
}
