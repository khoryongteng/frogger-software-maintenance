package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class End is the goal for the {@link frogger.models.actors.Player} in {@link frogger.models.levels.Level} classes.</p>
 * <p>End is added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a End in the level.</p>
 */
public class End extends Actor implements IActivatable{
	
	private boolean activated = false;
	private Image end = new Image("file:src/main/resources/images/End.png", 49, 49, true, true);
	private Image frogEnd = new Image("file:src/main/resources/images/FrogEnd.png", 49, 49, true, true);
	
	/**
	 * <p>The constructor of End.</p>
	 * <p>Initial image of End when it is not activated is set here.</p>
	 * @param x the position of End on the x-axis.
	 * @param y the position of End on the y-axis.
	 */
	public End(int x, int y) {
		setImage(end);
		setX(x);
		setY(y);
	}
	
	/**
	 * <p>Activate End and change image to image when activated.</p>
	 */
	public void activate() {
		setImage(frogEnd);
		activated = true;
	}
	
	/**
	 * <p>Get whether End is activated.</p>
	 * @return boolean whether end is activated.
	 */
	public boolean isActivated() {
		return activated;
	}

}
