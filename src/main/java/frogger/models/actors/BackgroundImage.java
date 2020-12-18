package frogger.models.actors;

import javafx.scene.image.Image;

/**
 * <p>The class BackgroundImage is a background for the {@link frogger.models.levels.Level} classes.</p>
 * <p>BackgroundImage is added into {@link frogger.models.levels.Level} classes using {@link frogger.models.levels.Level#add(Actor)} to create a visible instance of a BackgroundImage in the level.</p>
 */
public class BackgroundImage extends Actor{


	/**
	 * <p>The constructor of BackgroundImage.</p>
	 * <p>The image of BackgroundImage is set here.</p>
	 */ 
	public BackgroundImage() {
		
		setImage(new Image("file:src/main/resources/images/GameBackground.png", 600, 800, true, true));
		
	}

}
